package com.example.konstellation

import android.app.Application

class KonstellationApp: Application() {
    companion object {
        lateinit var instance: KonstellationApp
            private set
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}