package com.example.core.designSystem.core

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Light Theme",
    showBackground = true,
)
@Preview(
    name = "Night Theme",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
annotation class DesignSystemPreview