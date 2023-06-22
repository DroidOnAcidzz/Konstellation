package com.example.konstellation.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.konstellation.KonstellationApp
import com.example.konstellation.constellationGenerator.ConstellationManager
import com.example.konstellation.constellationGenerator.dataClasses.Star

@Composable
fun DisplayConstellation() {
    for (star in KonstellationApp.constellationManager.currentConstellation.stars)
    {
       Star(star = star)
    }
}

@Composable
fun Star(star: Star) {
    AppTheme() {
        Box(Modifier.size(65.dp,75.dp)
            .offset(star.position.x.dp,star.position.y.dp))
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
                onClick = star.onClick,
            )
            {
                Icon(
                    imageVector = ImageVector.vectorResource(star.imageResource) ,
                    contentDescription = star.name)
            }
        }


    }
}