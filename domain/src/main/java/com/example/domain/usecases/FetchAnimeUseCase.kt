package com.example.domain.usecases

import com.example.domain.either.Either
import com.example.domain.models.DataItem
import com.example.domain.repositories.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAnimeUseCase @Inject constructor(private val repository: AnimeRepository){

    operator fun invoke(): Flow<Either<String, List<DataItem>>> = repository.fetchAnime()
}