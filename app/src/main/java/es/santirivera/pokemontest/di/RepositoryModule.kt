package es.santirivera.pokemontest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.santirivera.data.api.PokemonDataSource
import es.santirivera.domain.repo.PokemonRepository
import es.santirivera.domain.repo.PokemonRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesPokemonRepository(
        dataSource: PokemonDataSource
    ):PokemonRepository = PokemonRepositoryImpl(dataSource)

}