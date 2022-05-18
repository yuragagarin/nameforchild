package ru.ernestoguevara.nameforchild.data.repositories.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.ernestoguevara.nameforchild.data.entities.MonthEntity

@Dao
interface  MonthDao {

    @Query("select * from monthes order by monthId asc")
    fun getOrdByValue(): List<MonthEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: MonthEntity)

    @Query("select * from monthes where value = :value")
    fun getByValue(value:String): MonthEntity

}