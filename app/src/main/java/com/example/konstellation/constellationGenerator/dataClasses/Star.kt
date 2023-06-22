package com.example.konstellation.constellationGenerator.dataClasses

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector

data class Star(var name:String,
                var imageResource:Int,
                val type: StarType,
                var position:Offset,
                val onClick: () -> Unit) {
}