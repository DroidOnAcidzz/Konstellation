package com.example.konstellation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldAccountForm(
    modifier: Modifier = Modifier,
    text: String = "",
    isPassword:Boolean=false
) {
    var keyboardOptions: KeyboardOptions = KeyboardOptions()
    var visualTransformation:VisualTransformation=VisualTransformation.None
    val textState = remember {mutableStateOf(text)}
    if(isPassword) {
        visualTransformation = PasswordVisualTransformation()
        keyboardOptions= KeyboardOptions(keyboardType = KeyboardType.Password)
    }
        BasicTextField(
            modifier = modifier.background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(10.dp))
                .padding(5.dp)
                .width(150.dp)
                .onFocusChanged {if (it.isFocused && textState.value==text) textState.value=""
                else if(!it.isFocused && textState.value=="") textState.value=text },
            singleLine = true,
            textStyle= TextStyle(fontSize = 8.sp, color = MaterialTheme.colorScheme.primary),
            value = textState.value,
            keyboardOptions = keyboardOptions,
            onValueChange = {textState.value=it},
            visualTransformation = visualTransformation
        )
}


@Preview
@Composable
fun TexfieldPreviews() {
    AppTheme() {
        TextFieldAccountForm(text =  "EMAIL")
    }
}