package ru.ernestoguevara.nameforchild.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "names")
data class NameEntity(

    @PrimaryKey(autoGenerate = true)
    val nameId: Long,
    var value: String,          // имя
    var meaning: String,        // значение имени
    var source: String,         // происхождение имени
    var nameDay: String?,       // именины
    var derivedName: String?,   // производные имена
    var talisman: String?,      // талисман
    var compatible: String?,    // совместим с именами
    var sex: String            // пол

){
    constructor(value: String, meaning: String, source: String, nameDay: String?
                ,derivedName: String?, talisman: String?, compatible: String?, sex: String)
            : this(0L, value, meaning, source, nameDay, derivedName, talisman, compatible, sex)
}