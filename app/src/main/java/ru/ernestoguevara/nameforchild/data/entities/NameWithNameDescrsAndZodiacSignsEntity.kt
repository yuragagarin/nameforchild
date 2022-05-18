package ru.ernestoguevara.nameforchild.data.entities

import androidx.room.*

@Entity
data class NameWithNameDescrsAndZodiacSignsEntity(

    @Embedded val name: NameEntity,

    @Relation(
        parentColumn = "nameId",
        entityColumn = "refNameId",
    )
    val nameDescrs: List<NameDescrEntity>,

    @Relation(
        parentColumn = "nameId",
        entityColumn = "zodiacSignId",
        associateBy = Junction(NameZodiacSignCrossEntity::class)
    )
    val zodiacSigns: List<ZodiacSignEntity>


)