package es.santirivera.data.api.model

data class ResponsePokemonList(
    val count: Int,
    val results: ArrayList<ResponsePokemon>
)

data class ResponsePokemon(
    val name: String = "",
    val url: String = ""
)

data class ResponsePokemonDetail(
    val base_experience: Int,
    val height: Int,
    val weight: Int,
    val name: String
)