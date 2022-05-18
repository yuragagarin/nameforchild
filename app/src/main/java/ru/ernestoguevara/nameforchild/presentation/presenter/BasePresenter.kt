package ru.ernestoguevara.nameforchild.presentation.presenter

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<T : BaseView>() : MvpPresenter<T>() {

    val subscriptBag: CompositeDisposable by lazy { CompositeDisposable() }

    fun addSubscript(disposable: Disposable) {
        subscriptBag.add(disposable);
    }

    override fun onDestroy() {
        subscriptBag.dispose()
        super.onDestroy()
    }

}