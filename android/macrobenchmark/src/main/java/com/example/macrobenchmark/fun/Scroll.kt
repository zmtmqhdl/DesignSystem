package com.example.macrobenchmark.`fun`

import androidx.benchmark.macro.MacrobenchmarkScope

enum class ScrollDirection {
    UP, DOWN
}

fun MacrobenchmarkScope.scroll(
    scrollDirection: ScrollDirection
) {
    when (scrollDirection) {
        ScrollDirection.UP -> scrollUp()
        ScrollDirection.DOWN -> scrollDown()
    }
}

private fun MacrobenchmarkScope.scrollDown() {
    repeat(3) {
        device.swipe(500, 1500, 500, 300, 20)
    }
}

private fun MacrobenchmarkScope.scrollUp() {
    repeat(3) {
        device.swipe(500, 300, 500, 1500, 20)
    }
}