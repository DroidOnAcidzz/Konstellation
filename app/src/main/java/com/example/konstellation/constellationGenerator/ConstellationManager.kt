package com.example.konstellation.constellationGenerator

import androidx.compose.ui.geometry.Offset
import com.example.konstellation.apps.Star
import com.example.konstellation.constellationGenerator.dataClasses.Constellation
import com.example.konstellation.constellationGenerator.dataClasses.DataStar
import com.example.konstellation.constellationGenerator.dataClasses.StarType

import kotlin.math.hypot
import kotlin.math.pow
import kotlin.math.sqrt

class ConstellationManager(ScreenWidth: Double,ScreenHeight: Double) {
    private val width: Double
    private val height: Double
    val constellations:MutableList<Constellation> = mutableListOf()
    lateinit var currentConstellation:Constellation
    init {
        width = ScreenWidth
        height = ScreenHeight
    }
    fun addStar(star: DataStar){
        val newStar = DataStar("",0, StarType.MATRIX, Offset(0.0F, 0.0F), Star())
        newStar.name=star.name
        newStar.imageResource=star.imageResource
        newStar.type=star.type
     //   newStar.login=star.login
        if (constellations.size!=0)
        {
            //star.position= findStarPosition(currentConstellation,star)
            star.position= generateRandomPosition()
            currentConstellation.stars.add(newStar)
            currentConstellation=reArrangeConstellation2(currentConstellation)
        }
        else{
            star.position= generateRandomPosition()
            createNewConstellation(newStar)
        }
    }
    private fun createNewConstellation(star: DataStar){
        currentConstellation = Constellation(
            ConstellationNames.getRandomConstellationName(),
            mutableListOf(star))
        constellations.add(currentConstellation)
    }

//    private fun checkDistanceBetweenStars(positions:MutableList<Offset>,amountOfDistanceToCheck:Double,width: Double,height:Double):Offset{
//        var foundViablePosition = false
//        var position = generateRandomPosition(width,height)
//        if (positions.size>1)
//        {
//            while (!foundViablePosition)
//            {
//                var hasPositionAvailable = true
//                for (p in positions)
//                {
//                    if(distanceBetweenStars(position,p) <amountOfDistanceToCheck)
//                    {
//                        hasPositionAvailable=false
//                    }
//                }
//                if (hasPositionAvailable)
//                    foundViablePosition=true
//                else
//                    position = generateRandomPosition(width, height)
//            }
//            return position
//        }
//        else
//        {
//            return position
//        }
//    }
    private fun reArrangeConstellation2(constellation: Constellation):Constellation
    {
        val radius=60.0
        val tempConstellation = constellation
        while (true)
        {
            var foundPositions=true
            for (star in constellation.stars)
            {
                for (tempStar in tempConstellation.stars)
                {
                    if (tempStar!=star)
                    {
                        if (distanceBetweenStars(tempStar.position,star.position)<radius)
                        {
                            tempStar.position=generateRandomPosition()
                            foundPositions=false
                        }
                    }
                }
            }
            if (foundPositions) {
                return tempConstellation
            }
        }
    }
    private fun reArrangeConstellation(constellation: Constellation){
        var isStarsSpread = false
        val minimumDistance = 60
        val starsTooClose:MutableList<DataStar> = mutableListOf()
        while (!isStarsSpread) {
            starsTooClose.clear()
            for (star in constellation.stars)
            {
                for (starToCompare in constellation.stars) {
                    if (star!=starToCompare)
                        if (distanceBetweenStars(star.position,starToCompare.position)<minimumDistance)
                        {
                            starsTooClose.add(star)
                        }
                }
            }
            for (starToRearrange in starsTooClose)
            {
                if(constellation.stars.equals(starToRearrange))

                {
                    starToRearrange.position = generateRandomPosition()
                    constellation.stars[constellation.stars.indexOf(starToRearrange)] =
                        starToRearrange
                }
            }
            if (starsTooClose.isEmpty())
                isStarsSpread=true
        }
    }
    private fun findStarPosition(constellation: Constellation,star: DataStar):Offset{
        val radius = 60.0
        while(true)
        {
            val tempPosition=generateRandomPosition()
            val isColliding = constellation.stars.any {
                val distance = sqrt((star.position.x.toDouble() - tempPosition.x).pow(2.0) + (star.position.y.toDouble() - tempPosition.y).pow(
                    2.0
                )
                )
                distance < radius + radius
            }
            if (!isColliding) {
                star.position=tempPosition
                return star.position   // Found a non-colliding position
            }

        }
    }
    private fun distanceBetweenStars(pos1: Offset, pos2: Offset):Double{
        return hypot(pos2.x-pos1.x,pos2.y-pos1.y).toDouble()
    }
    private fun generateRandomPosition():Offset
    {
        val randomPositionX = kotlin.random.Random.nextDouble(
            (width * 0.1f),
            (width * 0.8f)
        )
        val randomPositionY = kotlin.random.Random.nextDouble(
            (height * 0.2f),
            (height * 0.8f)
        )
        return Offset(randomPositionX.toFloat(), randomPositionY.toFloat())
    }
}
