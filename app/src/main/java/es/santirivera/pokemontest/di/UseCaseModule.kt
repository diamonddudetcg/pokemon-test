package es.santirivera.pokemontest.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import es.santirivera.domain.repo.PokemonRepository
import es.santirivera.domain.usecase.detail.LoadPokemonDetailUseCase
import es.santirivera.domain.usecase.detail.LoadPokemonDetailUseCaseImpl
import es.santirivera.domain.usecase.list.LoadPokemonListUseCase
import es.santirivera.domain.usecase.list.LoadPokemonListUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun providesPokemonListUseCase(pokemonRepository: PokemonRepository): LoadPokemonListUseCase =
        LoadPokemonListUseCaseImpl(pokemonRepository)

    @Provides
    fun providesPokemonDetailUseCase(pokemonRepository: PokemonRepository): LoadPokemonDetailUseCase =
        LoadPokemonDetailUseCaseImpl(pokemonRepository)

}