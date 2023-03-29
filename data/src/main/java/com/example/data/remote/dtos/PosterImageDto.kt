package com.example.data.remote.dtos

import com.example.domain.models.PosterImage
import com.google.gson.annotations.SerializedName

data class PosterImageDto(
    @SerializedName("original")
    val original: String = "",
)

fun PosterImageDto.toDomain() : PosterImage = PosterImage(
    original
)