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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.konstellation.R
import com.example.konstellation.constellationGenerator.dataClasses.Star
import com.example.konstellation.constellationGenerator.dataClasses.StarApps
import com.example.konstellation.constellationGenerator.dataClasses.StarType
import com.example.konstellation.home.None

@Composable
fun AppBar(modifier: Modifier=Modifier,
           accountsNavController: NavController = rememberNavController(),
           onStarAdded:()->Unit) {
    val navController = rememberNavController()
    val accountFormNavController = rememberNavController()
    var isAddingStar by remember { mutableStateOf(false)}
    val onAppBarStarAdded:()->Unit={
        isAddingStar=false
        onStarAdded()
    }
    val onAddingStar:()->Unit={
        isAddingStar=true
    }
        AppTheme() {
            Box(modifier = modifier.fillMaxSize()) {
                NavHost(
                    navController = accountFormNavController,
                    startDestination = "none",
                    Modifier.align(Alignment.Center)
                ) {
                    composable("none"){ None()}
                    composable ("test") { AccountsForm(accountsNavController,StarType.MATRIX)}
                    composable("accountForm/{starType}",
                        arguments = listOf(navArgument("starType"){type = NavType.IntType}))
                    {
                        val type = it.arguments?.getInt("starType")?:0
                        AccountsForm(accountFormNavController,StarType.values()[type])
                    }
                }
                Box(Modifier.align(Alignment.BottomCenter))
                {
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
                            composable("apps") { AppBarApps(onAddingStar, accountFormNavController) }
                        }
                    }

                }
            }
        }

    }
@Composable
fun AppBarApps(onAddingStar:()->Unit,accountsNavController: NavController= rememberNavController()) {
    Row(modifier= Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center)
    {
        for (star in StarApps.StarApps)
        {
            AppButton(modifier = Modifier,
                onAddingStar = {
                            onAddingStar()
                          },
                star = star,
            accountFormNavController = accountsNavController)
        }
    }
}
@Composable
fun AppButton(modifier: Modifier,
              onAddingStar: () -> Unit,
              star: Star,
              accountFormNavController: NavController) {
    Box(modifier = modifier) {
        AppTheme() {
            Box(Modifier.size(65.dp,75.dp)) {
                IconButton(
                    modifier= Modifier
                        .size(60.dp, 60.dp)
                        .alpha(0.85f)
                        .padding(2.dp)
                        .align(Alignment.TopCenter)
                        .shadow(2.dp, CircleShape)
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = CircleShape
                        ),
                    onClick = {
                        accountFormNavController.navigate("accountForm/"+star.type.ordinal)
//                        val newStar = Star("",0, StarType.MATRIX, Offset(0.0F, 0.0F))
//                        newStar.name=star.name
//                        newStar.imageResource=star.imageResource
//                        newStar.type=star.type
//                        KonstellationApp.constellationManager.addStar(newStar)
                        onAddingStar()

                    },
                )
                {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = star.imageResource),
                        contentDescription = "Matrix")
                }
                Text(text = star.name,
                    color= MaterialTheme.colorScheme.onPrimary,
                    fontSize = 10.sp,
                    modifier = Modifier.align(Alignment.BottomCenter),
                    textAlign = TextAlign.Center)
            }


        }
    }

}
@Preview
@Composable
fun AppBarPreview() {
    AppTheme(false) {
        ActivityScreen()
        Box(Modifier.fillMaxSize()) {
            AppBar(Modifier.align(Alignment.BottomCenter)) {}
        }
    }


}
