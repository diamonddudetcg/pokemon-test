package es.santirivera.domain.repo

import es.santirivera.data.api.PokemonDataSource
import es.santirivera.domain.model.PokemonDetail
import es.santirivera.domain.model.PokemonListItem
import es.santirivera.domain.model.toPokemonDetail
import es.santirivera.domain.model.toPokemonListItemList


class PokemonRepositoryImpl(
    private val dataSource: PokemonDataSource
) : PokemonRepository {

    override suspend fun getPokemonList(): List<PokemonListItem> {
        return dataSource.getPokemonList(2000, 0).toPokemonListItemList()
    }

    override suspend fun getDetail(url: String): PokemonDetail {
        return dataSource.getPokemonDetail(url).toPokemonDetail()
    }
}