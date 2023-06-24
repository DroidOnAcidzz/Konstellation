package com.example.konstellation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.konstellation.R
import com.example.konstellation.constellationGenerator.dataClasses.Star
import com.example.konstellation.constellationGenerator.dataClasses.StarApps
import com.example.konstellation.constellationGenerator.dataClasses.StarType

@Composable
fun AccountsForm(star: Star) {
    Box(modifier = Modifier
        .background(
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            shape = RoundedCornerShape(10.dp),
        )
        .size(300.dp, 200.dp)) {
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
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            TextTitle(text = stringResource(R.string.accounts_add_account),
                Modifier.padding(top = 5.dp))
            TextAccountForm(text = stringResource(R.string.accounts_account_name),
                Modifier.padding(10.dp) )
            TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_name_field)) {}
            TextAccountForm(text = stringResource(R.string.accounts_account_password),
                Modifier.padding(10.dp) )
            TextFieldAccountForm(text = stringResource(id = R.string.accounts_account_name_field),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)) {}
        }
    }
}
@Composable
fun AccountMixedForm(){

}

@Preview
@Composable
fun AccountFormPreview() {
    AppTheme() {
        AccountsForm(star = StarApps.Matrix)
    }

}