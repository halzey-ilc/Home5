package com.example.data.repositories

import com.example.data.remote.dtos.toDomain
import com.example.data.remote.apiservice.AnimeApiService
import com.example.domain.either.Either
import com.example.domain.models.DataItem
import com.example.domain.repositories.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepositoryImpl @Inject constructor(private val service: AnimeApiService) :
    AnimeRepository {

    override fun fetchAnime() = flow<Either<String, List<DataItem>>> {
        emit(Either.Right(service.fetchAnime().data.map {
            it.toDomain()
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Error Occurred!!"))
    }
}