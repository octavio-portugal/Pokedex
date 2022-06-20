package com.dio.octaviolportugal.mypokedex.data.service

import com.dio.octaviolportugal.mypokedex.data.model.Pokemons
import com.dio.octaviolportugal.mypokedex.data.model.PokemonWithoutIdResponse
import retrofit2.Response

class ApiClient(
    private val pokemonService: IBaseApiService
) {

    suspend fun getPokemonById(pokemonId: String): Response<Pokemons>{
        return pokemonService.getPokemonById(pokemonId)
    }

    suspend fun getPokemonWithoutId(): Response<PokemonWithoutIdResponse>{
        return pokemonService.getPokemonListWithoutId()
    }
}