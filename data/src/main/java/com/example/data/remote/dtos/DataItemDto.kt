package com.example.data.remote.dtos

import com.example.domain.models.DataItem
import com.google.gson.annotations.SerializedName

data class DataItemDto(
    @SerializedName("attributes")
    val attributes: AttributesDto,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)
fun DataItemDto.toDomain() : DataItem = DataItem(
    attributes.toDomain(),
    id,
    type
)
