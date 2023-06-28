package com.example.konstellation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.konstellation.KonstellationApp
import com.example.konstellation.api.matrix.MatrixService
import com.example.konstellation.ui.apps.ScreenMatrix
import retrofit2.Retrofit

class MatrixActivity(accountIndex:Int): ComponentActivity() {
    private val index = accountIndex
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val instance = KonstellationApp.accountManager.getAccountByIndex(index).instance
        val api:MatrixService = Retrofit.Builder()
            .baseUrl(instance)
            .build()
            .create(MatrixService::class.java)
        setContent{ScreenMatrix(instance = KonstellationApp.accountManager.getAccountByIndex(index).instance )}
    }
}