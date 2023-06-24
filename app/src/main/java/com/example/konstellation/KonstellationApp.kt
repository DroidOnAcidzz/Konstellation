package com.example.konstellation

import android.app.Application
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.compose.ui.unit.dp
import com.example.konstellation.accounts.AccountManager
import com.example.konstellation.constellationGenerator.ConstellationManager

class KonstellationApp: Application() {

    companion object {
        lateinit var constellationManager: ConstellationManager
        lateinit var instance: KonstellationApp
        val accountManager:AccountManager = AccountManager()

    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        val screenWidth:Double = (Resources.getSystem().displayMetrics.widthPixels/Resources.getSystem().displayMetrics.scaledDensity).toDouble()
        val screenHeight:Double = (Resources.getSystem().displayMetrics.heightPixels/Resources.getSystem().displayMetrics.scaledDensity).toDouble()
        constellationManager = ConstellationManager(screenWidth,screenHeight)
    }
}