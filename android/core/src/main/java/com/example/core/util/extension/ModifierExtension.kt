package com.example.core.util.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.ParentDataModifier

inline fun Modifier.conditional(
    condition: Boolean,
    modifier: Modifier.() -> Modifier
): Modifier {
    return if (condition) then(modifier()) else this
}

fun Modifier.onlyLayoutModifier(): Modifier {
    var result: Modifier = Modifier
    this.foldIn(Unit) { _, element ->
        val isLayoutRelated = when (element) {
            is ParentDataModifier -> {
                val name = element::class.java.simpleName
                !name.contains("Weight", ignoreCase = true)
            }
            is LayoutModifier -> {
                val name = element::class.java.simpleName
                name.contains("Offset", ignoreCase = true)
            }
            else -> false
        }
        if (isLayoutRelated) {
            result = result.then(element)
        }
    }
    return result
}