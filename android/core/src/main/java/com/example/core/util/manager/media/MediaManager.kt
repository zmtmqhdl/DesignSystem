package com.example.core.util.manager.media

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import java.io.File

enum class MediaSource { PHOTO, VIDEO, GALLERY }
enum class GalleryFilter { IMAGE, VIDEO, ALL }
enum class GallerySelectionMode { SINGLE, MULTIPLE }

data class MediaConfig(
    val mediaSource: MediaSource,
    val saveToGallery: Boolean = false,
    val galleryFilter: GalleryFilter = GalleryFilter.ALL,
    val galleryMode: GallerySelectionMode = GallerySelectionMode.SINGLE
)

class MediaLauncher(
    private val config: MediaConfig,
    private val onLaunchPhoto: (Uri) -> Unit,
    private val onLaunchVideo: (Uri) -> Unit,
    private val onLaunchGallery: () -> Unit
) {
    fun launch(context: Context) {
        when (config.mediaSource) {
            MediaSource.PHOTO -> {
                val uri = createPrivateMediaUri(context = context, isVideo = false)
                onLaunchPhoto(uri)
            }
            MediaSource.VIDEO -> {
                val uri = createPrivateMediaUri(context = context, isVideo = true)
                onLaunchVideo(uri)
            }
            MediaSource.GALLERY -> onLaunchGallery()
        }
    }
}

private fun saveFileToGallery(context: Context, privateUri: Uri, isVideo: Boolean): Uri? {
    val resolver = context.contentResolver
    val prefix = if (isVideo) "VID" else "IMG"
    val mimeType = if (isVideo) "video/mp4" else "image/jpeg"
    val directory = if (isVideo) Environment.DIRECTORY_MOVIES else Environment.DIRECTORY_PICTURES
    val baseUri = if (isVideo) MediaStore.Video.Media.EXTERNAL_CONTENT_URI else MediaStore.Images.Media.EXTERNAL_CONTENT_URI

    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, "${prefix}_${System.currentTimeMillis()}${if(isVideo) ".mp4" else ".jpg"}")
        put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            put(MediaStore.MediaColumns.RELATIVE_PATH, directory)
        }
    }

    val galleryUri = resolver.insert(baseUri, contentValues) ?: return null

    return try {
        resolver.openInputStream(privateUri)?.use { input ->
            resolver.openOutputStream(galleryUri)?.use { output ->
                input.copyTo(output)
            }
        }
        galleryUri
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

private fun createPrivateMediaUri(context: Context, isVideo: Boolean): Uri {
    val directory = if (isVideo) Environment.DIRECTORY_MOVIES else Environment.DIRECTORY_PICTURES
    val prefix = if (isVideo) "VID" else "IMG"
    val suffix = if (isVideo) ".mp4" else ".jpg"

    val file = File(
        context.getExternalFilesDir(directory),
        "${prefix}_${System.currentTimeMillis()}$suffix"
    )
    return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
}

@Composable
fun rememberMediaLauncher(
    config: MediaConfig,
    onSuccess: (List<Uri>) -> Unit,
    onFailure: () -> Unit = {}
): MediaLauncher {
    var tempUriString by rememberSaveable { mutableStateOf<String?>(null) }

    val context = LocalContext.current.applicationContext
    val currentContext by rememberUpdatedState(context)

    val photoLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { success ->
        val uri = tempUriString?.toUri()
        if (success && uri != null) {
            val finalUri = if (config.saveToGallery) {
                saveFileToGallery(context = currentContext, privateUri = uri, isVideo = false) ?: uri
            } else {
                uri
            }
            onSuccess(listOf(finalUri))
        } else {
            onFailure()
        }
    }

    val videoLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CaptureVideo()
    ) { success ->
        val uri = tempUriString?.toUri()
        if (success && uri != null) {
            val finalUri = if (config.saveToGallery) {
                saveFileToGallery(context = currentContext, privateUri = uri, isVideo = true) ?: uri
            } else {
                uri
            }
            onSuccess(listOf(finalUri))
        } else {
            onFailure()
        }
    }

    val singleGalleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        if (uri != null) onSuccess(listOf(uri)) else onFailure()
    }

    val multipleGalleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickMultipleVisualMedia()
    ) { uris ->
        if (uris.isNotEmpty()) onSuccess(uris) else onFailure()
    }

    return remember(config) {
        MediaLauncher(
            config = config,
            onLaunchPhoto = { uri ->
                tempUriString = uri.toString()
                photoLauncher.launch(input = uri)
            },
            onLaunchVideo = { uri ->
                tempUriString = uri.toString()
                videoLauncher.launch(input = uri)
            },
            onLaunchGallery = {
                val isMultiple = config.galleryMode == GallerySelectionMode.MULTIPLE

                val visualMediaType = when (config.galleryFilter) {
                    GalleryFilter.IMAGE -> ActivityResultContracts.PickVisualMedia.ImageOnly
                    GalleryFilter.VIDEO -> ActivityResultContracts.PickVisualMedia.VideoOnly
                    GalleryFilter.ALL -> ActivityResultContracts.PickVisualMedia.ImageAndVideo
                }

                val request = PickVisualMediaRequest(mediaType = visualMediaType)

                if (isMultiple) {
                    multipleGalleryLauncher.launch(input = request)
                } else {
                    singleGalleryLauncher.launch(input = request)
                }
            }
        )
    }
}