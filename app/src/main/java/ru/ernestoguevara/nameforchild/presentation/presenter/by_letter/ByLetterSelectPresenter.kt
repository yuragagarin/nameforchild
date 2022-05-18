package ru.ernestoguevara.nameforchild.presentation.presenter.by_letter

import com.arellomobile.mvp.InjectViewState
import ru.ernestoguevara.nameforchild.presentation.presenter.BasePresenter

@InjectViewState
class ByLetterSelectPresenter: BasePresenter<ByLetterSelectView>() {

    private val TAG = ByLetterSelectPresenter::class.java.simpleName

    var selectedLetter: String? = null

    fun goToByLetterView(actionId: Int) {
        viewState.goToView(actionId)
    }
}