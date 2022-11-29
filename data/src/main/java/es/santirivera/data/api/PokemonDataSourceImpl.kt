package es.santirivera.data.api

import es.santirivera.data.api.model.ResponsePokemonDetail
import es.santirivera.data.api.model.ResponsePokemonList

class PokemonDataSourceImpl(
    private val pokemonApi: PokemonApi,
) : PokemonDataSource {
    override suspend fun getPokemonList(limit: Int, offset: Int): ResponsePokemonList {
        return pokemonApi.getPokemon(limit, offset)
    }

    override suspend fun getPokemonDetail(url: String): ResponsePokemonDetail {
        return pokemonApi.getPokemonDetail(url)
    }


}