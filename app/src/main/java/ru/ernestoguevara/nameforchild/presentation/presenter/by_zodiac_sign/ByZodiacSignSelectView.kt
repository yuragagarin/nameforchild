package ru.ernestoguevara.nameforchild.presentation.presenter.by_zodiac_sign

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseView

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface ByZodiacSignSelectView : BaseView {
    fun goToView(actionId: Int)
}