package com.example.konstellation.accounts

import com.example.konstellation.constellationGenerator.dataClasses.StarType

data class Account(
    val instance:String,
    val email:String,
    val password:String,
    val type:StarType) {

}