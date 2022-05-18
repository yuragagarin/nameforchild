package ru.ernestoguevara.nameforchild.presentation.presenter.main

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseView

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface MainView : BaseView {
    fun goToView(id: Int)
}