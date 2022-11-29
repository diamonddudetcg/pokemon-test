package es.santirivera.domain.usecase.list

import es.santirivera.domain.model.PokemonListItem
import es.santirivera.domain.repo.PokemonRepository
import es.santirivera.domain.usecase.BaseUseCase

abstract class LoadPokemonListUseCase(private val pokemonRepository: PokemonRepository) :
    BaseUseCase<Void, List<PokemonListItem>>()