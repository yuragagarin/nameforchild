package ru.ernestoguevara.nameforchild.presentation.presenter.by_zodiac_sign

import com.arellomobile.mvp.InjectViewState
import ru.ernestoguevara.nameforchild.presentation.presenter.BasePresenter

@InjectViewState
class ByZodiacSignSelectPresenter : BasePresenter<ByZodiacSignSelectView>() {

    private val TAG = ByZodiacSignSelectPresenter::class.java.simpleName

    var selected: String? = null

    fun goToByZodiacSignView(actionId: Int) {
        viewState.goToView(actionId)
    }
}