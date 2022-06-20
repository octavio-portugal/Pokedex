package com.dio.octaviolportugal.mypokedex.presentation.ui.pokedex.adapters

//class ImageAdapter(val image:ArrayList<PokemonByIdResponse>): RecyclerView.Adapter<ImageHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
//        val binding = ItemPokemonAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//
//        return ImageHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
//        holder.bind(image[position])
//    }
//
//    override fun getItemCount(): Int = image.size
//
//
//}
//
//class ImageHolder(private val binding: ItemPokemonAdapterBinding):RecyclerView.ViewHolder(binding.root) {
//
//    fun bind(image: PokemonByIdResponse){
//
//        Picasso.get().load(image?.sprites?.front_default).centerCrop().resize(120, 120).into(binding.imgPokemonItem)
//    }
//
//}
