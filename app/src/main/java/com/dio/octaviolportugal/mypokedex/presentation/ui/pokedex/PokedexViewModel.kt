package com.dio.octaviolportugal.mypokedex.presentation.ui.pokedex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dio.octaviolportugal.mypokedex.data.model.Pokemons
import com.dio.octaviolportugal.mypokedex.data.model.PokemonWithoutIdResponse
import com.dio.octaviolportugal.mypokedex.data.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokedexViewModel() : ViewModel() {

    private val repository = PokemonRepository()

    private val _pokemonByIdLiveData =  MutableLiveData<List<Pokemons>?>()
    val pokemonByIdLiveData : LiveData<List<Pokemons>?> = _pokemonByIdLiveData

    private val _pokemonsWtihoutIdLiveData = MutableLiveData<PokemonWithoutIdResponse?>()
    val pokemonsWtihoutIdLiveData: LiveData<PokemonWithoutIdResponse?> = _pokemonsWtihoutIdLiveData

//    fun refreshPokemon(pokemonId: String){
//        viewModelScope.launch {
//            val response = repository.getPokemonById(pokemonId)
//
//            _pokemonByIdLiveData.postValue()
//        }
//    }

    fun refreshListOfPokemonsWithoutId(){
        viewModelScope.launch {
            val response = repository.getPokemonWithoutId()

            _pokemonsWtihoutIdLiveData.postValue(response)
        }
    }

    fun refreshPokemon(){
        viewModelScope.launch {
            val response = repository.getPokemonInformation()

            _pokemonByIdLiveData.postValue(response)
        }
    }
}
