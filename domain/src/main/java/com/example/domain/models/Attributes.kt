package com.example.domain.models

data class Attributes(
    val posterImage: PosterImage,
    val description: String = "",
    val titles: Titles,
)