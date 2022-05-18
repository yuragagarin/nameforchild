package ru.ernestoguevara.nameforchild.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "name_descrs",
    foreignKeys = [
        ForeignKey(
            entity = NameEntity::class,
            parentColumns = ["nameId"],
            childColumns = ["refNameId"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class NameDescrEntity(

    @PrimaryKey (autoGenerate = true)
    val id: Long,
    val text: String, // текст
    var refNameId: Long,

    ) {
    constructor(text: String) : this(0, text, 0L)
    constructor(id: Long,text: String) : this(id, text, 0L)
}