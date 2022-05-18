package ru.ernestoguevara.nameforchild.di

import dagger.Module
import dagger.Provides
import ru.ernestoguevara.nameforchild.presentation.presenter.adapter.NameAdapter
import javax.inject.Singleton

@Module
class AdapterModule {

    @Singleton
    @Provides
    fun provideByLetterAdapter() : NameAdapter { return NameAdapter() }

}