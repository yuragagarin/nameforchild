package ru.ernestoguevara.nameforchild.data.entities

import androidx.room.Entity

@Entity(tableName = "name_zodiac_sign_cross", primaryKeys = ["nameId", "zodiacSignId"])
data class NameZodiacSignCrossEntity(

    val nameId: Long,
    val zodiacSignId: Long

)