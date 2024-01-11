package com.example.aplikasijogging

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class AplikasiJogging : Application() {
    @Inject
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}