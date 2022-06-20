package com.dio.octaviolportugal.mypokedex.data.model

data class PokemonWithoutIdResponse (
    var results : List<ResponseFromResult>
)

data class ResponseFromResult(
    var name : String,
    var url : String
)