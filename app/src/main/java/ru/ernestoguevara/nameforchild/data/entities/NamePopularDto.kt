package ru.ernestoguevara.nameforchild.data.entities

import com.google.gson.annotations.SerializedName

data class NamePopularDto(
    @SerializedName("Cells")
    val cells: List<NamePopularCellDto>
)