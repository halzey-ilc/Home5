package com.example.data.repositories

import com.example.data.remote.dtos.toDomain
import com.example.data.remote.apiservice.MangaApiService
import com.example.domain.either.Either
import com.example.domain.models.DataItem
import com.example.domain.repositories.MangaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(private val service: MangaApiService) :
    MangaRepository {

    override fun fetchManga() = flow<Either<String, List<DataItem>>> {
        emit(Either.Right(service.fetchManga().data.map {
            it.toDomain()
        }))
    }.flowOn(Dispatchers.IO).catch {
        emit(Either.Left(it.localizedMessage ?: "Error Occurred!!"))
    }
}