package ru.ernestoguevara.nameforchild.presentation.presenter.detail_name

import ru.ernestoguevara.nameforchild.presentation.presenter.BaseView

interface DetailNameView : BaseView {
    fun startGetData()
    fun stopGetData()
    fun showError(message: Int)
    fun showData()
}