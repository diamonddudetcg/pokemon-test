package es.santirivera.pokemontest.fragment.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.santirivera.domain.model.PokemonDetail
import es.santirivera.domain.usecase.Callback
import es.santirivera.domain.usecase.detail.LoadPokemonDetailUseCase
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val loadPokemonDetailUseCase: LoadPokemonDetailUseCase
) :
    ViewModel(){

    fun loadPokemonDetail(url:String, callback: Callback<PokemonDetail>) {
        loadPokemonDetailUseCase.execute(url, callback)
    }
}