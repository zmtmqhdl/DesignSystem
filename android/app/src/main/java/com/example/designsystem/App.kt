package com.example.designsystem

import android.app.Application
import com.example.common.util.logger.DSLogger
import com.example.domain.model.AppConfig
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var appConfig: AppConfig

    override fun onCreate() {
        super.onCreate()
        DSLogger.initialize(appConfig)
    }
}
