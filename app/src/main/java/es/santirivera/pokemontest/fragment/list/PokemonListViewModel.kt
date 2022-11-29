package es.santirivera.pokemontest.fragment.list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.santirivera.domain.model.PokemonListItem
import es.santirivera.domain.usecase.Callback
import es.santirivera.domain.usecase.list.LoadPokemonListUseCase
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val loadPokemonUseCase: LoadPokemonListUseCase
) :
    ViewModel(){

    fun loadPokemon(callback: Callback<List<PokemonListItem>>) {
        loadPokemonUseCase.execute(null, callback)
    }
}