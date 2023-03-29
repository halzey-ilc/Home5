package com.example.presentation.models

import com.example.domain.models.Attributes
import com.example.domain.models.Titles
import com.google.gson.annotations.SerializedName

data class AttributesUI(
    @SerializedName("posterImage")
    val posterImage: PosterImageUI,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("titles")
    val titles: Titles,
)

fun Attributes.toUI(): AttributesUI = AttributesUI(
    posterImage.toUI(),
    description,
    titles
)