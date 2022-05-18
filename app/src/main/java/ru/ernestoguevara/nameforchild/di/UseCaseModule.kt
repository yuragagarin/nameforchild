package ru.ernestoguevara.nameforchild.di

import dagger.Module
import dagger.Provides
import ru.ernestoguevara.nameforchild.repositories.NameRepository
import ru.ernestoguevara.nameforchild.usecases.GetNamesByLetterUseCase
import ru.ernestoguevara.nameforchild.usecases.GetNamesBySourceUseCase
import ru.ernestoguevara.nameforchild.usecases.GetNamesByZodiacSignUseCase
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNamesByLetterUseCase(repo: NameRepository) : GetNamesByLetterUseCase { return GetNamesByLetterUseCase(repo) }

    @Singleton
    @Provides
    fun provideGetNamesBySourceUseCase(repo: NameRepository) : GetNamesBySourceUseCase { return GetNamesBySourceUseCase(repo) }

    @Singleton
    @Provides
    fun provideGetNamesByZodiacSignUseCase(repo: NameRepository) : GetNamesByZodiacSignUseCase { return GetNamesByZodiacSignUseCase(repo) }

}