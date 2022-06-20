package com.dio.octaviolportugal.mypokedex.data.model

import java.util.*

data class Pokemons(
    var sprites: Sprite,
//    var location_area_encounters: String
    var name : String
){
    var nameConfigured = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

data class Sprite(
    var front_default : String
)