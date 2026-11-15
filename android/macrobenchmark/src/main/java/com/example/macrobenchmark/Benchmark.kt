package com.example.macrobenchmark

import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.macrobenchmark.`fun`.ScrollDirection
import com.example.macrobenchmark.`fun`.scroll
import com.example.macrobenchmark.`fun`.launchAppFromHome
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Benchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startupAndScrollTest() {
        benchmarkRule.measureRepeated(
            packageName = BenchmarkConfig.PACKAGE_NAME,
            metrics = listOf(StartupTimingMetric(),),
            iterations = 10,
            startupMode = StartupMode.COLD
        ) {
            launchAppFromHome()
            scroll(ScrollDirection.DOWN)
            scroll(ScrollDirection.UP)
        }
    }

    @Test
    fun scrollTest() {
        benchmarkRule.measureRepeated(
            packageName = BenchmarkConfig.PACKAGE_NAME,
            metrics = listOf(FrameTimingMetric()),
            iterations = 10,
            startupMode = StartupMode.COLD
        ) {
            startActivityAndWait()

            repeat(3) {
                scroll(ScrollDirection.DOWN)
                scroll(ScrollDirection.UP)
            }
        }
    }
}