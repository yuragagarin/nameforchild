package ru.ernestoguevara.nameforchild.presentation.presenter.by_letter

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseView

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface ByLetterSelectView : BaseView {
    fun goToView(actionId: Int)
}