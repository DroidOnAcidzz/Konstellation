package com.example.konstellation.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ActivityScreen(){
    AppTheme() {
        Surface(modifier = Modifier.fillMaxSize())
        {
            Background()
        }
    }
}
@Preview
@Composable
fun Screens(){
    ActivityScreen()
}