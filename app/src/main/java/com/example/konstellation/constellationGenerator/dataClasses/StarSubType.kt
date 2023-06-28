package com.example.konstellation.constellationGenerator.dataClasses

import com.example.konstellation.R

data class StarSubType(
    var name:String = "Full App",
    var imageResource:Int  = R.drawable.mixed,
    var type:Subtype = Subtype.APP
)
