package com.example.konstellation.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun TextCenter(text:String,modifier: Modifier=Modifier) {
    Text (text = text,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        modifier =  modifier.fillMaxWidth())
}

@Composable
fun TextTitle(text:String, modifier: Modifier=Modifier) {
    Text (text = text,
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.primary,)
}

