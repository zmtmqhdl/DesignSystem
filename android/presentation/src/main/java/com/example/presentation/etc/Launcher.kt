package com.example.presentation.etc

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.core.content.FileProvider
import java.io.File

// object Launcher {
fun createImageUri(
    context: Context,
): Uri {
    val file = File(
        context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
        "IMG_${System.currentTimeMillis()}.jpg"
    )
    return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
}

fun createVideoUri(
    context: Context,
): Uri {
    val file = File(
        context.getExternalFilesDir(Environment.DIRECTORY_MOVIES),
        "VID_${System.currentTimeMillis()}.mp4"
    )
    return FileProvider.getUriForFile(
        context,
        "${context.packageName}.fileprovider",
        file
    )
}

@Composable
fun photoLauncher(
    onSuccess: () -> Unit = {},
    onFailure: () -> Unit = {},
): ManagedActivityResultLauncher<Uri, Boolean> {
    return rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            onSuccess()
        } else {
            onFailure()
        }
    }
}

@Composable
fun videoLauncher(
    uri: Uri?,
    onSuccess: () -> Unit = {},
    onFailure: () -> Unit = {},
): ManagedActivityResultLauncher<Uri, Boolean> {
    return rememberLauncherForActivityResult(ActivityResultContracts.CaptureVideo()) { success ->
        if (success) {
            uri?.let {
                onSuccess()
            }
        } else {
            onFailure()
        }
    }
}

// for chat
@Composable
fun mediaLauncher(
    context: Context,
    onImageSuccess: (List<Uri>) -> Unit,
    onVideoSuccess: (List<Uri>) -> Unit,
    onFailure: () -> Unit = {},
): ManagedActivityResultLauncher<Array<String>, List<Uri>> {

    return rememberLauncherForActivityResult(
        ActivityResultContracts.OpenMultipleDocuments()
    ) { uris: List<Uri> ->
        if (uris.isNotEmpty()) {
            val imageUriList = mutableListOf<Uri>()
            val videoUriList = mutableListOf<Uri>()

            uris.forEach { uri ->
                val mimeType = context.contentResolver.getType(uri)
                when {
                    mimeType?.startsWith("image/") == true -> {
                        imageUriList.add(uri)
                    }

                    mimeType?.startsWith("video/") == true -> {
                        videoUriList.add(uri)
                    }
                }
            }

            if (imageUriList.isNotEmpty()) {
                onImageSuccess(imageUriList)
            }
            if (videoUriList.isNotEmpty()) {
                onVideoSuccess(videoUriList)
            }
        } else {
            onFailure()
        }
    }
}
