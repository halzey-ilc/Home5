package com.example.home5.di

import com.example.data.repositories.AnimeRepositoryImpl
import com.example.data.repositories.MangaRepositoryImpl
import com.example.domain.repositories.AnimeRepository
import com.example.domain.repositories.MangaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindAnimeRepository(repositoryImpl: AnimeRepositoryImpl): AnimeRepository

    @Binds
    fun bindMangaRepository(repositoryImpl: MangaRepositoryImpl): MangaRepository
}