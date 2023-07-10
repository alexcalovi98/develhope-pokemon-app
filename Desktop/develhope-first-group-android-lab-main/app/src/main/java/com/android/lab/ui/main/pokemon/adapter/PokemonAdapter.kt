package com.android.lab.ui.main.pokemon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.disk.DiskCache
import coil.load
import com.android.lab.databinding.PokemonItemBinding

class PokemonAdapter(private val items : MutableList<PokemonItem> = mutableListOf()) : RecyclerView.Adapter<PokemonAdapter.ViewHolder> () {

    inner class ViewHolder(private val binding : PokemonItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val imageLoader = ImageLoader.Builder(itemView.context)
            .diskCache {
                DiskCache.Builder()
                    .directory(itemView.context.cacheDir.resolve("image_cache"))
                    .maxSizePercent(0.02)
                    .build()
            }.components {
                add(SvgDecoder.Factory())
            }.build()

        fun onBind(item : PokemonItem) {
            binding.pokemonImage.load(item.image, imageLoader)
            binding.textPokemon.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    fun addItems(itemsToAdd: List<PokemonItem>){
        items.addAll(itemsToAdd)
        notifyDataSetChanged() //TODO use notifyItemRangeChanged
    }
}