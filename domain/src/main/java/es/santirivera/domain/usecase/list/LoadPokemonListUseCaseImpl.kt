package es.santirivera.domain.usecase.list

import es.santirivera.domain.model.PokemonListItem
import es.santirivera.domain.repo.PokemonRepository

class LoadPokemonListUseCaseImpl(private val pokemonRepository: PokemonRepository) :
    LoadPokemonListUseCase(pokemonRepository) {

    override suspend fun run(params: Void?): List<PokemonListItem> {
        return pokemonRepository.getPokemonList()
    }
}