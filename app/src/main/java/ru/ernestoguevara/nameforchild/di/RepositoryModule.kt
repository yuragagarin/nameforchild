package ru.ernestoguevara.nameforchild.di

import dagger.Module
import dagger.Provides
import ru.ernestoguevara.nameforchild.data.repositories.local.NameDao
import ru.ernestoguevara.nameforchild.data.mappers.NameMapper
import ru.ernestoguevara.nameforchild.data.mappers.NamePopularMapper
import ru.ernestoguevara.nameforchild.data.repositories.NameRepositoryImpl
import ru.ernestoguevara.nameforchild.data.repositories.remote.NamePopularApi
import ru.ernestoguevara.nameforchild.repositories.NameRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNameRepository(dao: NameDao, namePopularApi: NamePopularApi, nameMapper: NameMapper, namePopularMapper: NamePopularMapper)
            : NameRepository {
        return NameRepositoryImpl(dao, namePopularApi, nameMapper, namePopularMapper)
    }

}