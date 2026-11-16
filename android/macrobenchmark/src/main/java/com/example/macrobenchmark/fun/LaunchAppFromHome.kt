package com.example.macrobenchmark.`fun`

import androidx.benchmark.macro.MacrobenchmarkScope

fun MacrobenchmarkScope.launchAppFromHome() {
    pressHome()
    startActivityAndWait()
}