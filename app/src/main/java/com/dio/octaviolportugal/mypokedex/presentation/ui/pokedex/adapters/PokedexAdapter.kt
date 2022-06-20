package com.dio.octaviolportugal.mypokedex.presentation.ui.pokedex.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dio.octaviolportugal.mypokedex.data.model.Pokemons
import com.dio.octaviolportugal.mypokedex.databinding.ItemPokemonAdapterBinding
import com.squareup.picasso.Picasso

class PokedexAdapter(var items :ArrayList<Pokemons>): RecyclerView.Adapter<PokedexHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexHolder {
        val binding = ItemPokemonAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PokedexHolder(binding)
    }

    override fun onBindViewHolder(holder: PokedexHolder, position: Int) {

//        var pokemonPosition = pokemon[position]
        holder.bind(items[position])
        // usar o position para realizar a chamada com o ID
    }

    override fun getItemCount(): Int = items.size
}

class PokedexHolder(private val binding: ItemPokemonAdapterBinding) :
    RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Pokemons){
        binding.txtNameItem.text = data.nameConfigured


        Picasso.get().load(data.sprites?.front_default).centerCrop().resize(120, 120).into(binding.imgPokemonItem)
    }
}
