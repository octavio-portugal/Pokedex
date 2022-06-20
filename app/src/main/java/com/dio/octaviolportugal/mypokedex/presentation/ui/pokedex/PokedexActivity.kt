package com.dio.octaviolportugal.mypokedex.presentation.ui.pokedex

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dio.octaviolportugal.mypokedex.data.model.Pokemons
import com.dio.octaviolportugal.mypokedex.databinding.PokedexActivityBinding
import com.dio.octaviolportugal.mypokedex.presentation.ui.pokedex.adapters.PokedexAdapter

class PokedexActivity : AppCompatActivity() {

    val viewModel: PokedexViewModel by lazy {
        ViewModelProvider(this).get(PokedexViewModel::class.java)
    }

    private val binding: PokedexActivityBinding
            by lazy {
                PokedexActivityBinding.inflate(layoutInflater)
            }

    private lateinit var pokedexAdapter: PokedexAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ApiCall()

        val pokemon = arrayListOf<Pokemons>()

        pokedexAdapter = PokedexAdapter(pokemon)
        binding.rvPokedex.adapter = pokedexAdapter
        binding.rvPokedex.layoutManager = LinearLayoutManager(this)

        pokedexAdapter
    }

    private fun ApiCall() {

        viewModel.refreshPokemon()
        viewModel.pokemonByIdLiveData.observe(this@PokedexActivity) {
            if (it == null) {
                Toast.makeText(this, "Unsuccessful network call!", Toast.LENGTH_LONG).show()
                Log.d("Error", it.toString())
                return@observe
            }

            pokedexAdapter.items.clear()
            pokedexAdapter.items.addAll(it)
            pokedexAdapter.notifyDataSetChanged()

        }

//            viewModel.refreshPokemon(i.name)
//            viewModel.pokemonByIdLiveData.observe(this@PokedexActivity) { responseId ->
//                if (responseId == null) {
//                    Toast.makeText(this, "Unsuccessful network call!", Toast.LENGTH_LONG).show()
//                    Log.d("Error", responseId.toString())
//                    return@observe
//                }
//
//                Log.d("Resposta:", responseId.toString())
//
//                var image = responseId.sprites.front_default
//                binding.txtName.text = responseId.name
//                Picasso.get().load(image).centerCrop().resize(120, 120).into(binding.imgPokemon)
//
//                pokedexAdapter.items.clear()
//                pokedexAdapter.items.addAll()
//                pokedexAdapter.notifyDataSetChanged()
//
//            }
    }
}

//    private fun CallObserver(id: Unit): Pokemons {
//
//        val getPokemon : Pokemons = viewModel.pokemonByIdLiveData.observe(this@PokedexActivity) { observe ->
//            observe.map {
//                Pokemons(it.sprites, it.name)
//            }
//        }
//        return getPokemon
//    }
