package com.example.core.util.extension

import androidx.compose.ui.Modifier

inline fun Modifier.conditional(
    condition: Boolean,
    modifier: Modifier.() -> Modifier
): Modifier {
    return if (condition) then(modifier()) else this
}