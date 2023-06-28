package com.example.konstellation.ui.theme

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.konstellation.KonstellationApp
import com.example.konstellation.constellationGenerator.dataClasses.DataStar

@Composable
fun DisplayConstellation() {
    Box(Modifier
        .fillMaxSize()
        .drawBehind {
        var previousOffset: Offset = KonstellationApp.constellationManager.currentConstellation.stars[0].position
        var nextOffset:Offset
        val density = Resources.getSystem().displayMetrics.density
        val starCenterOffset = 30*density
        for (star in KonstellationApp.constellationManager.currentConstellation.stars)
        {
            if (star!=KonstellationApp.constellationManager.currentConstellation.stars[0]) {
                nextOffset = star.position
                drawLine(color = Color.White,
                    start = Offset((previousOffset.x * density)+starCenterOffset,
                        (previousOffset.y * density)+starCenterOffset),
                    end = Offset((nextOffset.x * density)+starCenterOffset,(nextOffset.y * density)+starCenterOffset),
                strokeWidth = 4f)
                previousOffset = nextOffset
            }
        }
    }) {
        Text (modifier = Modifier.fillMaxSize()
            .align(Alignment.TopCenter)
            .padding(top =100.dp),
            textAlign = TextAlign.Center,
            text = KonstellationApp.constellationManager.currentConstellation.name,
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 32.sp)
        for (star in KonstellationApp.constellationManager.currentConstellation.stars)
        {
            Star(star = star)
        }
    }

}

@Composable
fun Star(star: DataStar) {
    AppTheme() {
        Box(
            Modifier
                .size(65.dp, 75.dp)
                .offset(star.position.x.dp, star.position.y.dp))
        {
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
                onClick = {},
            )
            {
                Icon(
                    imageVector = ImageVector.vectorResource(star.imageResource) ,
                    contentDescription = star.name)
            }
        }


    }
}