package es.santirivera.domain.usecase.detail

import es.santirivera.domain.model.PokemonDetail
import es.santirivera.domain.repo.PokemonRepository
import es.santirivera.domain.usecase.BaseUseCase

abstract class LoadPokemonDetailUseCase(private val pokemonRepository: PokemonRepository) :
    BaseUseCase<String, PokemonDetail>()