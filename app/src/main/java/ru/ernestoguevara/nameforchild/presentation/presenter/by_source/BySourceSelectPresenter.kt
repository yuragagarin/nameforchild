package ru.ernestoguevara.nameforchild.presentation.presenter.by_source

import com.arellomobile.mvp.InjectViewState
import ru.ernestoguevara.nameforchild.presentation.presenter.BasePresenter

@InjectViewState
class BySourceSelectPresenter : BasePresenter<BySourceSelectView>() {

    private val TAG = BySourceSelectPresenter::class.java.simpleName

    var selected: String? = null

    fun goToBySourceView(actionId: Int) {
        viewState.goToView(actionId)
    }
}