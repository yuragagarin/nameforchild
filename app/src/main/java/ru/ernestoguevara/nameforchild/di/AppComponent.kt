package ru.ernestoguevara.nameforchild.di

import dagger.Component
import ru.ernestoguevara.nameforchild.presentation.App
import ru.ernestoguevara.nameforchild.presentation.service.DataLoaderService
import ru.ernestoguevara.nameforchild.presentation.presenter.by_letter.ByLetterFragment
import ru.ernestoguevara.nameforchild.presentation.presenter.by_letter.ByLetterPresenter
import ru.ernestoguevara.nameforchild.presentation.presenter.by_source.BySourceFragment
import ru.ernestoguevara.nameforchild.presentation.presenter.by_source.BySourcePresenter
import ru.ernestoguevara.nameforchild.presentation.presenter.by_zodiac_sign.ByZodiacSignFragment
import ru.ernestoguevara.nameforchild.presentation.presenter.by_zodiac_sign.ByZodiacSignPresenter
import ru.ernestoguevara.nameforchild.presentation.presenter.detail_name.DetailNameFragment
import ru.ernestoguevara.nameforchild.presentation.presenter.detail_name.DetailNamePresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [LocalDbModule::class, AdapterModule::class, MapperModule::class, RepositoryModule::class
            ,UseCaseModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(app: App)

    //services
    fun inject(service: DataLoaderService)

    //presenters
    fun inject(presenter: ByLetterPresenter)
    fun inject(presenter: ByZodiacSignPresenter)
    fun inject(presenter: DetailNamePresenter)
    fun inject(presenter: BySourcePresenter)

    //fragments
    fun inject(fragment: ByLetterFragment)
    fun inject(fragment: ByZodiacSignFragment)
    fun inject(fragment: DetailNameFragment)
    fun inject(fragment: BySourceFragment)

}