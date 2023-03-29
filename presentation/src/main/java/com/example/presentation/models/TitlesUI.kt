package com.example.presentation.models

import com.example.domain.models.Titles
import com.google.gson.annotations.SerializedName

data class TitlesUI(
    @SerializedName("en_jp")
    val enJp: String = ""
)

fun Titles.toUI(): TitlesUI = TitlesUI(
    enJp
)