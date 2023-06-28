package com.example.konstellation.apps

import com.example.konstellation.R
import com.example.konstellation.constellationGenerator.dataClasses.StarSubType
import com.example.konstellation.constellationGenerator.dataClasses.Subtype

class StarPeertube:StarApp() {
    override var subTypes: MutableList<StarSubType> = mutableListOf(
        StarSubType("App", R.drawable.mixed, Subtype.APP)
    )
}