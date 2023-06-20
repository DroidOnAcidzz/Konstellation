package com.example.konstellation.ui.theme

import android.content.res.loader.ResourcesLoader
import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.konstellation.R
import com.example.konstellation.home.DrawConstellation
import com.example.konstellation.home.None

@Composable
fun AppBar(modifier: Modifier) {
    val navController = rememberNavController()
    Box(modifier = modifier)
    {
        AppTheme() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(10.dp)
                    .shadow(elevation = 2.dp, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(MaterialTheme.colorScheme.primaryContainer)
            )
            {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    text = stringResource(R.string.apps_title_app_bar),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .shadow(1.dp)
                        .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
                )

                NavHost(navController = navController, startDestination = "apps") {
                    composable("apps") { AppBarApps() }
                    composable("constellation") { DrawConstellation(NumberOfStars = 7) }
                }

            }
        }

    }
}
@Composable
fun AppBarApps() {
    Row(modifier= Modifier.fillMaxHeight(),verticalAlignment = Alignment.CenterVertically) {
        AppButtonMastodon()
        AppButtonMatrix()
        AppButtonPeertube()
        AppButtonMixed()
        AppButtonConstellation()
    }
}
@Composable
fun AppButtonMatrix(){
    AppButton(modifier = Modifier,
        onClick = { /*TODO*/ },
        text = "Matrix",
        imageVector = ImageVector.vectorResource(
            id = R.drawable.matrix_icon ))
}

@Composable
fun AppButtonMastodon(){
    AppButton(modifier = Modifier,
        onClick = { /*TODO*/ },
        text = "Mastodon",
        imageVector = ImageVector.vectorResource(
            id = R.drawable.mastodon_icon ))
}@Composable
fun AppButtonConstellation(){
    AppButton(modifier = Modifier,
        onClick = { /*TODO*/ },
        text = "Constellation",
        imageVector = ImageVector.vectorResource(
            id = R.drawable.constellation ))
}
@Composable
fun AppButtonPeertube(){
    AppButton(modifier = Modifier,
        onClick = { /*TODO*/ },
        text = "Peertube",
        imageVector = ImageVector.vectorResource(
            id = R.drawable.peertube_icon ))
}
@Composable
fun AppButtonMixed(){
    AppButton(modifier = Modifier,
        onClick = { /*TODO*/ },
        text = "Mixed",
        imageVector = ImageVector.vectorResource(
            id = R.drawable.mixed ))
}
@Preview
@Composable
fun AppBarPreview() {
    ActivityScreen()
    Box(Modifier.fillMaxSize()) {
        AppBar(modifier = Modifier.align(Alignment.BottomCenter))
    }

}
