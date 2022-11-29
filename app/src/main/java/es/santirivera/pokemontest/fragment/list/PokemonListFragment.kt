package es.santirivera.pokemontest.fragment.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import es.santirivera.domain.model.PokemonListItem
import es.santirivera.domain.usecase.Callback
import es.santirivera.pokemontest.fragment.base.PokemonFragment
import es.santirivera.pokemontest.R
import es.santirivera.pokemontest.databinding.FragmentItemListBinding
import es.santirivera.pokemontest.fragment.list.adapter.PokemonListAdapter
import es.santirivera.pokemontest.fragment.list.adapter.viewholder.PokemonViewHolder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.lang.Exception

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PokemonListFragment : PokemonFragment(),
    PokemonViewHolder.OnPokemonClickedCallback, Callback<List<PokemonListItem>> {

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonListViewModel by viewModels()

    private val adapter = PokemonListAdapter(ArrayList(), this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.itemList
        setupRecyclerView(recyclerView)
        startLoad()
        viewModel.loadPokemon(this)
    }


    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = adapter
        binding.itemList.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPokemonClicked(item: PokemonListItem) {
        findNavController().navigate(
            PokemonListFragmentDirections.showItemDetail(item.name, item.url)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onSuccess(response: List<PokemonListItem>) {
        adapter.setNewValues(response)
        adapter.notifyDataSetChanged()
        endLoad()
    }

    override fun onError(error: Exception) {
        error.printStackTrace()
        Toast.makeText(context, R.string.error_no_internet, Toast.LENGTH_LONG).show()
    }
}