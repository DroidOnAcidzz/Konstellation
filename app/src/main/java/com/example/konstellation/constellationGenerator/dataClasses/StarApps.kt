package com.example.konstellation.constellationGenerator.dataClasses

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.konstellation.R

class StarApps {
    companion object
    {
        val Matrix:Star = Star(
            name = "Matrix",
            imageResource= R.drawable.matrix_icon,
            type = StarType.MATRIX,
            position = Offset(0.0F, 0.0F))
        val Mastodon:Star = Star(
            name = "Mastodon",
            imageResource= R.drawable.mastodon_icon,
            type = StarType.MASTODON,
            position = Offset(0.0F, 0.0F))
        val Peertube:Star = Star(
            name = "Peertube",
            imageResource= R.drawable.peertube_icon,
            type = StarType.PEERTUBE,
            position = Offset(0.0F, 0.0F))
        val Mixed:Star = Star(
            name = "Mixed",
            imageResource= R.drawable.mixed,
            type = StarType.MIXED,
            position = Offset(0.0F, 0.0F))
        val Constellation:Star = Star(
            name = "Constellation",
            imageResource= R.drawable.constellation,
            type = StarType.CONSTELLATION,
            position = Offset(0.0F, 0.0F))
        val StarApps:List<Star> = listOf(Matrix, Mastodon, Peertube, Mixed, Constellation)
        fun getStarAppByType(type:StarType):Star
        {
            for (app in StarApps)
            {
                if (app.type==type)
                {
                    return app
                }
            }
            return Matrix
        }
    }

}