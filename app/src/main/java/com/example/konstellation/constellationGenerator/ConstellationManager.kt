package com.example.konstellation.constellationGenerator

import androidx.compose.ui.geometry.Offset
import com.example.konstellation.constellationGenerator.dataClasses.Constellation
import com.example.konstellation.constellationGenerator.dataClasses.Star

import kotlin.math.hypot

class ConstellationManager(ScreenWidth: Double,ScreenHeight: Double) {
    private val width: Double
    private val height: Double
    lateinit var constellations:MutableList<Constellation>
    lateinit var currentConstellation:Constellation
    init {
        width = ScreenWidth
        height = ScreenHeight
    }
    fun addStar(star: Star){
        if (constellations.size!=0)
        {
            currentConstellation.stars.add(star)
            reArrangeConstellation(currentConstellation)
        }
        else{
            createNewConstellation(star)
        }
    }
    private fun createNewConstellation(star: Star){
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
    private fun reArrangeConstellation(constellation: Constellation){
        var isStarsSpread = false
        val minimumDistance = 60
        val starsTooClose:MutableList<Star> = mutableListOf<Star>()
        while (!isStarsSpread) {
            starsTooClose.clear()
            for (star in constellation.stars)
            {
                for (starToCompare in constellation.stars) {
                    var hasStarClose = false
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
