package com.example.konstellation.apps

import com.example.konstellation.constellationGenerator.dataClasses.StarSubType
import com.example.konstellation.constellationGenerator.dataClasses.Subtype

open class Star {
    open var subTypes:MutableList<StarSubType> = mutableListOf()
    fun travel(){

    }
    fun onTravel(){

    }
}