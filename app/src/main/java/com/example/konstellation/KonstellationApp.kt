package com.example.konstellation

import android.app.Application
import com.example.konstellation.constellationGenerator.ConstellationManager

class KonstellationApp: Application() {
    companion object {
        lateinit var instance: KonstellationApp
        lateinit var constellationManager: ConstellationManager

    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}