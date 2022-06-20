package com.dio.octaviolportugal.mypokedex.data.repository

import android.util.Log
import com.dio.octaviolportugal.mypokedex.data.model.Pokemons
import com.dio.octaviolportugal.mypokedex.data.model.PokemonWithoutIdResponse
import com.dio.octaviolportugal.mypokedex.data.service.NetworkLayer

class PokemonRepository {

    suspend fun getPokemonById(pokemonId: String): Pokemons? {
        val request = NetworkLayer.apiClient.getPokemonById(pokemonId)

        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }

    suspend fun getPokemonWithoutId(): PokemonWithoutIdResponse? {
        val request = NetworkLayer.apiClient.getPokemonWithoutId()

        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }

    suspend fun getPokemonInformation(): List<Pokemons>? {
        val request = NetworkLayer.apiClient.getPokemonWithoutId()

        if (request.isSuccessful) {
            Log.d("Resposta direta:", request.body().toString() )
           return request.body()?.results?.map {

                val getInformation = NetworkLayer.apiClient.getPokemonById(it.name)

                getInformation.body().let {
                        Pokemons(it!!.sprites, it.name)
                }
            }
        }
        return null
    }
}

//        if (request.isSuccessful) {
//            request.body().let { response ->
//                response?.results?.map {
//
//                    val getInformation = NetworkLayer.apiClient.getPokemonById(it.name)
//
//                    getInformation.body().let {
//                        it?.map {
//                            Pokemons(it.sprites, it.name)
//                        }
//                    }
//                }
//            }
//        }
//        return null


