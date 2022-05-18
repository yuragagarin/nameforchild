package ru.ernestoguevara.nameforchild.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "monthes")
data class MonthEntity(
    @PrimaryKey (autoGenerate = true) val monthId: Short,
    val value: String
    ){
    constructor(value: String) : this(0,value)
}