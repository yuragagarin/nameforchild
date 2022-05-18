package ru.ernestoguevara.nameforchild.presentation.presenter

import com.moxy_mvp.androidx.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    override fun toastShort(msg: String) {
        TODO("Not yet implemented")
    }

    override fun toastShort(resId: Int) {
        TODO("Not yet implemented")
    }

    override fun toastLong(msg: String) {
        TODO("Not yet implemented")
    }

    override fun toastLong(resId: Int) {
        TODO("Not yet implemented")
    }

    override fun showNoInternetConnectionError() {
        TODO("Not yet implemented")
    }
}