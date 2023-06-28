package com.example.konstellation.ui.apps

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.konstellation.ui.theme.ActivityScreen

@Composable
fun ScreenMatrix(instance:String) {
    ActivityScreen()
    Text(text = instance)

}

@Preview
@Composable
fun MatrixScreenPreview() {
    ScreenMatrix(instance = "Matrix")
}
