package ru.ernestoguevara.nameforchild.presentation.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.ernestoguevara.nameforchild.presentation.App
import ru.ernestoguevara.nameforchild.data.DataConfig
import ru.ernestoguevara.nameforchild.entities.AllSrcLink
import ru.ernestoguevara.nameforchild.data.entities.NameEntity
import ru.ernestoguevara.nameforchild.entities.NameSrcLink
import javax.inject.Inject

class DataLoaderService : Service() {

    @Inject
    lateinit var dataProvider: DataProvider

    @Inject
    lateinit var dataHolder: DataHolder

    var started: Boolean = false

    override fun onCreate() {
        super.onCreate()

        App.instance.appComponent.inject(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        start()
        started = true
        Log.i("I", "Service started")

        return super.onStartCommand(intent, flags, startId)

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        started = false
        Log.i("I", "Service stopped")
    }

    private fun start() {
        loadCatalogs()
            .subscribeOn(Schedulers.io())
            .subscribe({

                var boysSrc = getLinks(DataConfig.BOY_NAMES_PATH, "m").subscribeOn(Schedulers.io())
                var girlsSrc =
                    getLinks(DataConfig.GIRL_NAMES_PATH, "w").subscribeOn(Schedulers.io())

                var allSrc = Single.zip(boysSrc, girlsSrc, { firstResonse: List<NameSrcLink>,
                                                             secondResponse: List<NameSrcLink> ->
                    AllSrcLink(firstResonse, secondResponse)
                })

                allSrc.subscribeOn(Schedulers.io())
                    .subscribe({

                        processItems(it.boys).subscribeOn(Schedulers.io())
                            .subscribe(
                                {
                                    Log.d("D", it.value)
                                }, {
                                    Log.e("E", "Ошибка при обработке мужских имён")
                                }
                            )

                        processItems(it.girls).subscribeOn(Schedulers.io())
                            .subscribe(
                                {
                                    Log.d("D", it.value)
                                }, {
                                    Log.e("E", "Ошибка при обработке женских имён")
                                }
                            )

                    }, {
                        Log.e("DataLoaderService", it.message.toString())
                    })

            },
                {
                    Log.e("E", "Ошибка при обработке имён 2")
                })

    }

    private fun loadCatalogs(): Completable {
        return Completable.create {
            dataProvider?.loadCatalogs()
            it.onComplete()
        }
    }

    private fun getLinks(path: String, sex: String): Single<List<NameSrcLink>> {
        return Single.create { emitter ->
            dataProvider?.let { emitter.onSuccess(it.loadList(path, sex)) }
        }
    }

    private fun processItems(items: List<NameSrcLink>): Observable<NameEntity> {

        return Observable.create { subscriber ->

            items.forEach {
                if (!started) return@create
                if (dataHolder?.exists(it.name) == true)
                    return@forEach

                val name = dataProvider?.loadOne(it)

                name?.let { itName -> dataHolder?.add(itName) }

                name?.let { subscriber.onNext(name.name) }

                Thread.sleep(3000)

            }

        }
    }

}