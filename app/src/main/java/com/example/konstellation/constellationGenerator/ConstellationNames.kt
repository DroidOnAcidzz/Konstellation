package com.example.konstellation.constellationGenerator

class ConstellationNames {
    val fakeConstellations = listOf(
        "Luminoth", "Zephyrion", "Stardustria", "Celestoria", "Nebuloria",
        "Astralis", "Solara", "Galaxara", "Aetherion", "Cosmara",
        "Stellarion", "Lunaris", "Ignis", "Seraphia", "Sylvaria",
        "Novarion", "Arcanis", "Astrionis", "Nebuloria", "Crystallum",
        "Astralis", "Astradon", "Nebulosus", "Celestria", "Stellaria",
        "Solaris", "Luminara", "Lyrius", "Aqualis", "Vortexia",
        "Zephyria", "Pyroxis", "Auroria", "Arcanum", "Radiantis",
        "Astronia", "Lunaria", "Fluxora", "Eclipta", "Chronia",
        "Zypheria", "Etherea", "Nebulora", "Serenara", "Novastra",
        "Aetheris", "Stellara", "Lumira", "Aurorium", "Solanum",
        "Zephyros", "Caelura", "Galactra", "Astrion", "Celestris",
        "Nebulastra", "Stellaris", "Lumis", "Sylvaris", "Celestros",
        "Nebulora", "Astralis", "Astronica", "Cosmica", "Radiara",
        "Ignara", "Novaris", "Zephyra", "Aerialis", "Nebulon",
        "Seraphium", "Arcanus", "Astrophia", "Celestrix", "Lunara",
        "Luminos", "Stellarum", "Zyphera", "Solvaris", "Aetherium",
        "Nebulos", "Celestria", "Astroria", "Ignisara", "Serenara",
        "Novastra", "Aethera", "Stellara", "Luminia", "Lyrastra",
        "Auroram", "Zephyrora", "Solarius", "Nebulosus", "Caelum",
        "Astralis", "Nebularis", "Stellaris", "Luminara", "Astronova"
    )
    fun getRandomConstellationName():String{
        return fakeConstellations.get(kotlin.random.Random.nextInt(0,fakeConstellations.size-1))
    }
}