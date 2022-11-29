package es.santirivera.domain.usecase.detail

import es.santirivera.domain.model.PokemonDetail
import es.santirivera.domain.repo.PokemonRepository

class LoadPokemonDetailUseCaseImpl(private val pokemonRepository: PokemonRepository) :
    LoadPokemonDetailUseCase(pokemonRepository) {

    override suspend fun run(params: String?): PokemonDetail {
        val id = params!!.replace("https://pokeapi.co/api/v2/pokemon/", "").replace("/", "")
        return pokemonRepository.getDetail(id)
    }
}