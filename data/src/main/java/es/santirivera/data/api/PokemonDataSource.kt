package es.santirivera.data.api

import es.santirivera.data.api.model.ResponsePokemonDetail
import es.santirivera.data.api.model.ResponsePokemonList

interface PokemonDataSource {

    @Throws(Exception::class)
    suspend fun getPokemonList(limit: Int, offset: Int): ResponsePokemonList

    @Throws(Exception::class)
    suspend fun getPokemonDetail(url:String) : ResponsePokemonDetail
}