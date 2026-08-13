package com.example.common.util.clipboard

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.FileProvider
import coil3.ImageLoader
import coil3.request.ImageRequest
import coil3.request.SuccessResult
import coil3.request.allowHardware
import coil3.toBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

suspend fun copyImageToClipboard(
    context: Context,
    imageModel: Any,
    authority: String = "${context.packageName}.fileprovider"
): Result<Uri> {
    return withContext(Dispatchers.IO) {
        runCatching {
            val imageLoader = ImageLoader(context)
            val request = ImageRequest.Builder(context)
                .data(imageModel)
                .allowHardware(false)
                .build()

            val result = imageLoader.execute(request)
            if (result !is SuccessResult) {
                throw IllegalStateException("Coil 이미지 로드 실패")
            }

            val bitmap: Bitmap = result.image.toBitmap()

            val imagesDir = File(context.cacheDir, "images").apply {
                if (!exists()) mkdirs()
            }

            val imageFile = File(imagesDir, "copied_image_${System.currentTimeMillis()}.png")
            FileOutputStream(imageFile).use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            }

            val contentUri: Uri = FileProvider.getUriForFile(context, authority, imageFile)

            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newUri(context.contentResolver, "Copied Image", contentUri)
            clipboard.setPrimaryClip(clip)

            contentUri
        }
    }
}