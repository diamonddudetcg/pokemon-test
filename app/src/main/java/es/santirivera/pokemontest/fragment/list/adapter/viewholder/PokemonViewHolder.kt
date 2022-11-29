package es.santirivera.pokemontest.fragment.list.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import es.santirivera.domain.model.PokemonListItem
import es.santirivera.pokemontest.databinding.ItemListContentBinding

class PokemonViewHolder(private val binding: ItemListContentBinding) :
    RecyclerView.ViewHolder(binding.root) {

    interface OnPokemonClickedCallback {
        fun onPokemonClicked(item: PokemonListItem)
    }


    fun setElement(item: PokemonListItem, callback: OnPokemonClickedCallback) {
        binding.textViewPokemonName.text = item.name.replaceFirstChar { c: Char -> c.uppercaseChar() }
        itemView.setOnClickListener {
            callback.onPokemonClicked(item)
        }
    }
}