package com.example.konstellation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.konstellation.R
import com.example.konstellation.constellationGenerator.dataClasses.StarApps

@Composable
fun AppBar(homeScreenNavController: NavController, onStarAdded:()->Unit) {
    val navController = rememberNavController()
    Box()
    {
        AppTheme() {
            Column(
                modifier = Modifier
                    .height(150.dp)
                    .padding(10.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 0.2.dp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(MaterialTheme.colorScheme.onPrimaryContainer)
            )
            {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    text = stringResource(R.string.apps_title_app_bar),
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
                Spacer(
                    modifier = Modifier
                        .height(0.2.dp)
                        .fillMaxWidth()
                        .shadow(2.dp)
                        .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
                )
                NavHost(navController = navController, startDestination = "apps") {
                    composable("apps") { AppBarApps(homeScreenNavController,onStarAdded) }
                }
            }
        }

    }
}
@Composable
fun AppBarApps(navController:NavController,onAnyButtonClicked:()->Unit) {
    Row(modifier= Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        for (star in StarApps.StarApps)
        {
            AppButton(modifier = Modifier,
                onClick = {onAnyButtonClicked()
                    star.onClick},
                text = star.name,
                imageVector = ImageVector.vectorResource(id = star.imageResource))
        }
    }
}
@Preview
@Composable
fun AppBarPreview() {
    ActivityScreen()
    Box(Modifier.fillMaxSize()) {
        AppBar(homeScreenNavController = rememberNavController()) {}
    }

}
