package com.example.konstellation.constellationGenerator.dataClasses

import androidx.compose.ui.geometry.Offset

data class Star(var name:String, val type: StarType, var position:Offset) {
}