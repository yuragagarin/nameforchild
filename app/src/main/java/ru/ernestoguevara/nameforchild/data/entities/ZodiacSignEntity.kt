package ru.ernestoguevara.nameforchild.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zodiac_signs")
data class ZodiacSignEntity(

    @PrimaryKey (autoGenerate = true) val zodiacSignId: Long,
    val value: String,

    ){
    constructor(value: String) : this(0L,value)
}