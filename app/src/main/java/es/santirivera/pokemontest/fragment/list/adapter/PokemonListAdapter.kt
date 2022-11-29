package es.santirivera.pokemontest.fragment.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.santirivera.domain.model.PokemonListItem
import es.santirivera.pokemontest.databinding.ItemListContentBinding
import es.santirivera.pokemontest.fragment.list.adapter.viewholder.PokemonViewHolder

class PokemonListAdapter(
    private val values: ArrayList<PokemonListItem>,
    private val callback: PokemonViewHolder.OnPokemonClickedCallback
) :
    RecyclerView.Adapter<PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding =
            ItemListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = values[position]
        holder.setElement(item, callback)
    }

    override fun getItemCount() = values.size

    fun setNewValues(it: List<PokemonListItem>) {
        values.clear()
        values.addAll(it)
    }

}