package com.example.konstellation.ui.theme

import android.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.konstellation.R
import com.example.konstellation.constellationGenerator.dataClasses.Star
import com.example.konstellation.constellationGenerator.dataClasses.StarApps
import com.example.konstellation.constellationGenerator.dataClasses.StarType

@Composable
fun AccountsForm(star: Star) {
    Box(modifier = Modifier
        .background(
            color = MaterialTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(10.dp),
        )
        .wrapContentSize()) {
        if (star.type!=StarType.MIXED)
            AccountAppForm(star = star)
        else
            AccountMixedForm()

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountAppForm(star:Star){
    Box(contentAlignment = Alignment.Center) {
        Image(imageVector = ImageVector.vectorResource(star.imageResource),
            contentDescription = "AppImage",
            modifier = Modifier.align(Alignment.CenterStart)
                .padding(start=14.dp).size(40.dp,40.dp),
        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint (MaterialTheme.colorScheme.primary) )
        Column(modifier= Modifier.padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            TextTitle(text = stringResource(R.string.accounts_add_account),
                Modifier.padding(top = 5.dp))
            TextAccountForm(text = stringResource(R.string.accounts_account_instance),)
            TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_url)) {}
            TextAccountForm(text = stringResource(R.string.accounts_account_name))
            TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_name_field)) {}
            TextAccountForm(text = stringResource(R.string.accounts_account_password),)
            TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_password),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)) {}
            if (star.type==StarType.MATRIX)
            {
                TextAccountForm(text = stringResource(R.string.accounts_account_token),)
                TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_token),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)) {}
            }
            ButtonLogin(modifier = Modifier.padding(20.dp),
                onClick = {})
        }
    }
}

@Composable
fun ButtonLogin(onClick:()->Unit,modifier:Modifier=Modifier) {
    Button(onClick = onClick,
    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
    modifier = modifier
        .width(160.dp)
        .height(22.dp),
    contentPadding = PaddingValues(0.dp))
    {
        Text(text = stringResource(id = R.string.accounts_account_login), fontSize = 8.sp)
    }

}
@Composable
fun AccountMixedForm(){

}
@Composable
fun TextAccountForm(text:String, modifier: Modifier=Modifier) {
    Text (text = text,
        textAlign = TextAlign.Center,
        fontSize = 10.sp,
        modifier = modifier.padding(5.dp),
        color = MaterialTheme.colorScheme.primary,)
}
@Preview
@Composable
fun AccountFormPreview() {
    AppTheme(false) {
        AccountsForm(star = StarApps.Peertube)
    }

}