package ru.ernestoguevara.nameforchild.presentation.presenter.by_source

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseView

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface BySourceSelectView : BaseView {
    fun goToView(actionId: Int)
}