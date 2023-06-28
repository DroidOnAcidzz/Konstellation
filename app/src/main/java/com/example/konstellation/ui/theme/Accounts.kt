package com.example.konstellation.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.konstellation.R
import com.example.konstellation.constellationGenerator.dataClasses.DataStar
import com.example.konstellation.constellationGenerator.dataClasses.StarApps
import com.example.konstellation.constellationGenerator.dataClasses.StarType

@Composable
fun AccountsForm(accountsNavController: NavController = rememberNavController(), type: StarType=StarType.MATRIX) {
    Box(modifier = Modifier.fillMaxSize())
    {
        Box(modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(10.dp)
            )
            .wrapContentSize()
            .align(Alignment.Center)
        ) {
            if (type!=StarType.MIXED)
                AccountAppForm(accountsNavController,star = StarApps.getStarAppByType(type))
            else
                AccountMixedForm()

        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountAppForm(accountsNavController: NavController = rememberNavController(),star:DataStar){
    Box(contentAlignment = Alignment.Center) {
        Image(imageVector = ImageVector.vectorResource(star.imageResource),
            contentDescription = "AppImage",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 14.dp)
                .size(40.dp, 40.dp),
        colorFilter = androidx.compose.ui.graphics.ColorFilter.tint (MaterialTheme.colorScheme.primary) )
        Column(modifier= Modifier.padding(14.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            TextTitle(text = stringResource(R.string.accounts_add_account),
                Modifier.padding(top = 5.dp))
            TextAccountForm(text = stringResource(R.string.accounts_account_instance),)
            TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_url))
            TextAccountForm(text = stringResource(R.string.accounts_account_name))
            TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_name_field))
            TextAccountForm(text = stringResource(R.string.accounts_account_password),)
            TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_password), isPassword = true)
            if (star.type==StarType.MATRIX)
            {
                TextAccountForm(text = stringResource(R.string.accounts_account_token))
                TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_token), isPassword = true)
            }
            ButtonLogin(modifier = Modifier.padding(top=20.dp),
                onClick = {
                       // KonstellationApp.constellationManager.addStar(star)
                })
            ButtonCancel(modifier = Modifier.padding(10.dp),
                onClick = { accountsNavController.navigate("none")}
                )
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
fun ButtonCancel(onClick:()->Unit,modifier:Modifier=Modifier) {
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
        modifier = modifier
            .width(60.dp)
            .height(22.dp),
        contentPadding = PaddingValues(0.dp))
    {
        Text(text = stringResource(id = R.string.accounts_account_cancel), fontSize = 8.sp)
    }
}
fun login(){

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
        AccountsForm(type = StarType.MATRIX)
    }

}