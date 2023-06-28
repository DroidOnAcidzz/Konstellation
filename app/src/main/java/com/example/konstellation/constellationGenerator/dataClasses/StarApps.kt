package com.example.konstellation.constellationGenerator.dataClasses

import androidx.compose.ui.geometry.Offset
import com.example.konstellation.R
import com.example.konstellation.apps.StarMastodon
import com.example.konstellation.apps.StarMatrix
import com.example.konstellation.apps.StarMixed
import com.example.konstellation.apps.StarPeertube

class StarApps {
    companion object
    {
        private val Matrix:DataStar = DataStar(
            name = "Matrix",
            imageResource= R.drawable.matrix_icon,
            type = StarType.MATRIX,
            position = Offset(0.0F, 0.0F),
            starClass = StarMatrix())
        private val Mastodon:DataStar = DataStar(
            name = "Mastodon",
            imageResource= R.drawable.mastodon_icon,
            type = StarType.MASTODON,
            position = Offset(0.0F, 0.0F),
            starClass = StarMastodon()
        )
        private val Peertube:DataStar = DataStar(
            name = "Peertube",
            imageResource= R.drawable.peertube_icon,
            type = StarType.PEERTUBE,
            position = Offset(0.0F, 0.0F),
            starClass = StarPeertube())
        private val Mixed:DataStar = DataStar(
            name = "Mixed",
            imageResource= R.drawable.mixed,
            type = StarType.MIXED,
            position = Offset(0.0F, 0.0F),
            starClass = StarMixed())
//        private val Constellation:DataStar = DataStar(
//            name = "Constellation",
//            imageResource= R.drawable.constellation,
//            type = StarType.CONSTELLATION,
//            position = Offset(0.0F, 0.0F),
//            star = StarConstellation())
        val StarApps:List<DataStar> = listOf(Matrix, Mastodon, Peertube, Mixed)
        fun getStarAppByType(type:StarType):DataStar
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