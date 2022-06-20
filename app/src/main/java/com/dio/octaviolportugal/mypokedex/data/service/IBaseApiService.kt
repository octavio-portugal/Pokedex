package com.dio.octaviolportugal.mypokedex.data.service

import com.dio.octaviolportugal.mypokedex.data.model.Pokemons
import com.dio.octaviolportugal.mypokedex.data.model.PokemonWithoutIdResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IBaseApiService {

    @GET("pokemon/{id}")
    suspend fun getPokemonById(
        @Path("id") pokemonId: String
    ) : Response<Pokemons>

    @GET("pokemon/?offset=0&limit=50")
    suspend fun getPokemonListWithoutId() : Response<PokemonWithoutIdResponse>
}