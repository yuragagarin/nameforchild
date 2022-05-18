package ru.ernestoguevara.nameforchild.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.ernestoguevara.nameforchild.data.repositories.local.MonthDao
import ru.ernestoguevara.nameforchild.data.repositories.local.NameDao
import ru.ernestoguevara.nameforchild.data.repositories.local.ZodiacSignDao
import ru.ernestoguevara.nameforchild.data.entities.*

@Database(entities = [ZodiacSignEntity::class, NameEntity::class, NameZodiacSignCrossEntity::class, NameDescrEntity::class, NamePopularEntity::class, MonthEntity::class], version = 1, exportSchema = false)
abstract class NameForChildDatabase : RoomDatabase() {

    abstract fun zodiacSignDao(): ZodiacSignDao
    abstract fun monthDao(): MonthDao
    abstract fun nameDao(): NameDao

}