package com.example.konstellation.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.konstellation.R

@Composable
fun TopButton(onClick: () -> Unit,modifier: Modifier=Modifier,text:String)
{
    AppTheme() {
        Box(modifier = modifier) {
            Button(
                colors= ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                modifier= Modifier
                    .size(60.dp, 60.dp)
                    .alpha(0.85f),
                onClick = onClick,
                shape = CircleShape,
                )
            {
                Text(text = text,
                    color= MaterialTheme.colorScheme.primary,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun AppButton(modifier: Modifier,onClick: () -> Unit,text: String,imageVector: ImageVector) {
    Box(modifier = modifier) {
        AppTheme() {
            Column(Modifier.width(60.dp)) {
                IconButton(
                    modifier= Modifier
                        .size(60.dp, 60.dp)
                        .alpha(0.85f)
                        .background(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = CircleShape
                        ),
                    onClick = onClick,
                )
                {
                    Icon(
                        imageVector = imageVector,
                        contentDescription = "Matrix")
                }
                Text(text = text,
                    color= MaterialTheme.colorScheme.primary,
                    fontSize = 10.sp,
                    modifier = Modifier.fillMaxWidth()
                        .padding(top=4.dp),
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
        AppButton(onClick = { /*TODO*/ },text="Matrix", modifier = Modifier.padding(10.dp), imageVector = ImageVector.vectorResource(
            id = R.drawable.matrix_icon
        ))

    }

}