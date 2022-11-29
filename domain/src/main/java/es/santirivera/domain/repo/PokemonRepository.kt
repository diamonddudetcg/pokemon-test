package es.santirivera.domain.repo

import es.santirivera.domain.model.PokemonDetail
import es.santirivera.domain.model.PokemonListItem

interface PokemonRepository {

    suspend fun getPokemonList(): List<PokemonListItem>

    suspend fun getDetail(id: String): PokemonDetail

}