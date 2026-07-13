package com.example.core.util.manager.permission

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat

@Stable
interface PermissionManager {
    fun launch(permissions: List<String>)
}

@Composable
fun rememberPermissionManager(
    onSuccess: () -> Unit,
    onDenied: () -> Unit,
    onPermanentlyDenied: (List<String>) -> Unit
): PermissionManager {
    val context = LocalContext.current
    val activity = context as? Activity ?: error("PermissionRequester requires an Activity context.")

    val currentOnSuccess = rememberUpdatedState(newValue = onSuccess)
    val currentOnDenied = rememberUpdatedState(newValue = onDenied)
    val currentOnPermanentlyDenied = rememberUpdatedState(newValue =  onPermanentlyDenied)

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        val deniedPermissions = result.filterValues { !it }.keys

        if (deniedPermissions.isEmpty()) {
            currentOnSuccess.value()
            return@rememberLauncherForActivityResult
        }

        val permanentlyDenied = deniedPermissions.filter { permission ->
            !ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
        }

        if (permanentlyDenied.isNotEmpty()) {
            currentOnPermanentlyDenied.value(permanentlyDenied.toList())
        } else {
            currentOnDenied.value()
        }
    }

    return remember(launcher) {
        object : PermissionManager {
            override fun launch(permissions: List<String>) {
                launcher.launch(input = permissions.toTypedArray())
            }
        }
    }
}