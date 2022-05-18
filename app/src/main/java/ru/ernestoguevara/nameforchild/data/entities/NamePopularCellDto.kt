package ru.ernestoguevara.nameforchild.data.entities

import com.google.gson.annotations.SerializedName

data class NamePopularCellDto (
    @SerializedName("NumberOfPersons") val numberOfPersons: Int,
    @SerializedName("Year") val year: Int,
    @SerializedName("Month") val month: String
    )

