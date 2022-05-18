package ru.ernestoguevara.nameforchild.di

import dagger.Module
import dagger.Provides
import ru.ernestoguevara.nameforchild.data.mappers.NameMapper
import ru.ernestoguevara.nameforchild.data.mappers.NamePopularMapper
import javax.inject.Singleton

@Module
class MapperModule {

    @Provides
    fun provideNameMapper() : NameMapper { return NameMapper() }

    @Provides
    fun provideNamePopularMapper() : NamePopularMapper { return NamePopularMapper() }
}