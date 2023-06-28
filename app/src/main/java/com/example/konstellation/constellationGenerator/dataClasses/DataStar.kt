package com.example.konstellation.constellationGenerator.dataClasses

import androidx.compose.ui.geometry.Offset
import com.example.konstellation.apps.Star

data class DataStar(var name:String,
                    var imageResource:Int,
                    var type: StarType,
                    var position:Offset,
                    var starClass: Star
) {
}