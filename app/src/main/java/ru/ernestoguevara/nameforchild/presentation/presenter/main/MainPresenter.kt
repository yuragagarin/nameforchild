package ru.ernestoguevara.nameforchild.presentation.presenter.main

import com.arellomobile.mvp.InjectViewState
import ru.ernestoguevara.nameforchild.presentation.presenter.BasePresenter

@InjectViewState
class MainPresenter: BasePresenter<MainView>() {

    private val TAG = MainPresenter::class.java.simpleName

    fun goToView(id: Int) {
        viewState?.goToView(id)
    }

}