package com.example.konstellation

import android.app.Application
import com.example.konstellation.constellationGenerator.ConstellationManager

class KonstellationApp: Application() {

    companion object {
        lateinit var constellationManager: ConstellationManager
        lateinit var instance: KonstellationApp


    }
    override fun onCreate() {
        super.onCreate()
        constellationManager = ConstellationManager(393.0,808.0)
        instance = this
    }
}