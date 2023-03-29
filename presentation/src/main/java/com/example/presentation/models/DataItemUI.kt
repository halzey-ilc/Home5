package com.example.presentation.models

import com.example.domain.models.DataItem
import com.google.gson.annotations.SerializedName

data class DataItemUI(
    @SerializedName("attributes")
    val attributes: AttributesUI,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)

fun DataItem.toUI(): DataItemUI = DataItemUI(
    attributes.toUI(),
    id,
    type
)