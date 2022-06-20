package com.dio.octaviolportugal.mypokedex.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object NetworkLayer {

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val pokemonService: IBaseApiService by lazy {
                retrofit.create(IBaseApiService::class.java)
            }
    val apiClient = ApiClient(pokemonService)
}

