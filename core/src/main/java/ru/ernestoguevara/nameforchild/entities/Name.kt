package ru.ernestoguevara.nameforchild.entities



data class Name(
    val id: Long,
    val value: String,                  // имя
    val meaning: String,                // значение имени
    val source: String,                 // происхождение имени
    val nameDay: String?,               // именины
    val derivedName: String?,           // производные имена
    val talisman: String?,              // талисман
    val compatible: String?,            // совместим с именами
    val sex: String,                    // пол
    val descrEntities: List<NameDescr>,
    val zodiacSigns: List<ZodiacSign>

)
