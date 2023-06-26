package com.example.konstellation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.konstellation.KonstellationApp
import com.example.konstellation.R
import com.example.konstellation.constellationGenerator.ConstellationManager
import com.example.konstellation.constellationGenerator.ConstellationNames
import com.example.konstellation.constellationGenerator.dataClasses.Star
import com.example.konstellation.constellationGenerator.dataClasses.StarType
import com.example.konstellation.ui.theme.ActivityScreen
import com.example.konstellation.ui.theme.AppBar
import com.example.konstellation.ui.theme.AppTheme
import com.example.konstellation.ui.theme.DisplayConstellation
import com.example.konstellation.ui.theme.TopButton

class HomeActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent { HomeScreen() }
    }
}
@Composable
fun HomeScreen() {
    val constellationController = rememberNavController()
    val appBarController = rememberNavController()
    val accountNavController = rememberNavController()
    var showAppBar by remember {
        mutableStateOf(false)
    }
    ActivityScreen()
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .align(Alignment.End)
            .padding(top = 20.dp)) {
            var appButtonAlpha=1.0f
            appButtonAlpha = if (!showAppBar) 1.0f else 0.5f
            TopButton(onClick =
            {
                if (!showAppBar){
                    showAppBar=true
                }

            }
                ,text = "+",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .alpha(appButtonAlpha))
            TopButton(onClick = { /*TODO*/ },text = "S", modifier = Modifier.padding(end = 20.dp))
        }
    }
    Box(Modifier.fillMaxSize()) {
                NavHost(navController = constellationController, startDestination = "none" ){
                    composable ("none"){ None()}
                    composable ("constellation"){ DisplayConstellation() }
        }
        if (showAppBar)
            AppBar(accountsNavController = appBarController) {
                showAppBar = false
                constellationController.navigate("constellation")
            }
    }
}

@Composable
fun None() {
    Box(modifier = Modifier.fillMaxSize())
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme() {
        HomeScreen()
    }
}