package es.santirivera.data.api

import es.santirivera.data.api.model.ResponsePokemonDetail
import es.santirivera.data.api.model.ResponsePokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): ResponsePokemonList

    @GET("pokemon/{id}/")
    suspend fun getPokemonDetail(@Path("id") id: String): ResponsePokemonDetail

}