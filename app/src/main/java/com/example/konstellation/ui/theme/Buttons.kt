package com.example.konstellation.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.konstellation.KonstellationApp
import com.example.konstellation.R
import com.example.konstellation.constellationGenerator.dataClasses.Star
import com.example.konstellation.constellationGenerator.dataClasses.StarType

@Composable
fun TopButton(onClick: () -> Unit,modifier: Modifier=Modifier,text:String,alpha:Float=1.0f)
{
    AppTheme() {
        Box(modifier = modifier) {
            Button(
                colors= ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                modifier= Modifier
                    .size(60.dp, 60.dp)
                    .alpha(0.85f)
                    .alpha(alpha),
                onClick = {onClick() },
                shape = CircleShape,
                )
            {
                Text(text = text,
                    color= MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center)
            }
        }
    }
}


@Preview
@Composable
fun ButtonsPreview(){
    Row {
        TopButton(onClick = { /*TODO*/ },text="+", modifier = Modifier.padding(10.dp))
        AppButton(onStarAdded = { /*TODO*/ },text="Matrix", modifier = Modifier.padding(10.dp), imageVector = ImageVector.vectorResource(
            id = R.drawable.matrix_icon), star = Star(
            name = "Matrix",
            imageResource= R.drawable.matrix_icon,
            type = StarType.MATRIX,
            position = Offset(0.0F, 0.0F)))

    }

}