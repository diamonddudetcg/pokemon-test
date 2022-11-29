package es.santirivera.domain.model

import es.santirivera.data.api.model.ResponsePokemon
import es.santirivera.data.api.model.ResponsePokemonDetail
import es.santirivera.data.api.model.ResponsePokemonList

fun ResponsePokemon.toPokemonListItem(): PokemonListItem{
    return PokemonListItem(name, url)
}

fun ResponsePokemonList.toPokemonListItemList(): List<PokemonListItem>{
    val list = ArrayList<PokemonListItem>()
    for (result in results){
        list.add(result.toPokemonListItem())
    }
    return list
}

fun ResponsePokemonDetail.toPokemonDetail(): PokemonDetail{
    return PokemonDetail(weight, height, base_experience, name)
}