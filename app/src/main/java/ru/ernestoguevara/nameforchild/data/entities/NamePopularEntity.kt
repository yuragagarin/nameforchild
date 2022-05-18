package ru.ernestoguevara.nameforchild.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "name_populars",
    foreignKeys = [
        ForeignKey(
            entity = NameEntity::class,
            parentColumns = ["nameId"],
            childColumns = ["refNameId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class NamePopularEntity(

    @PrimaryKey(autoGenerate = true)
    val namePopularId: Long,
    val year: Short,
    var refNameId: Long

)
