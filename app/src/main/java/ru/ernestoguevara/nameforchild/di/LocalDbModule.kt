package ru.ernestoguevara.nameforchild.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.ernestoguevara.nameforchild.data.repositories.local.NameDao
import ru.ernestoguevara.nameforchild.data.db.NameForChildDatabase
import javax.inject.Singleton

@Module
class LocalDbModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideNameForChildDatabase() : NameForChildDatabase {

        return Room.databaseBuilder(app, NameForChildDatabase::class.java, "nameforchild")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNameDao(db: NameForChildDatabase) : NameDao { return db.nameDao() }

    @Singleton
    @Provides
    fun provideZodiacSignDao(db: NameForChildDatabase) = db.zodiacSignDao()

}