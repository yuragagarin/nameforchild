package ru.ernestoguevara.nameforchild.presentation

import android.app.Application
import io.reactivex.plugins.RxJavaPlugins
import ru.ernestoguevara.nameforchild.di.AppComponent
import ru.ernestoguevara.nameforchild.di.DaggerAppComponent
import ru.ernestoguevara.nameforchild.di.LocalDbModule
import ru.ernestoguevara.nameforchild.data.db.NameForChildCreator


class App : Application() {

    companion object {

        lateinit var instance: App
            private set
    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        //NameForChildCreator().copyDataBaseIfNotExist(applicationContext)
        RxJavaPlugins.setErrorHandler { throwable: Throwable? -> } //https://coderoad.ru/52631581/RxJava2-UndeliverableException-когда-происходит-изменение-ориентации-при

        instance = this
        configureDi()
    }

    private fun configureDi() {
        appComponent = DaggerAppComponent.builder()
            .localDbModule(LocalDbModule(this))
            .build()
    }

}