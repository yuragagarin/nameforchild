package ru.ernestoguevara.nameforchild.data.repositories.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.ernestoguevara.nameforchild.data.entities.ZodiacSignEntity

@Dao
interface  ZodiacSignDao {

    @Query("select * from zodiac_signs order by zodiacSignId asc")
    fun getOrdByValue(): List<ZodiacSignEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: ZodiacSignEntity)

    @Query("select * from zodiac_signs where value = :value")
    fun getByValue(value:String): ZodiacSignEntity

}