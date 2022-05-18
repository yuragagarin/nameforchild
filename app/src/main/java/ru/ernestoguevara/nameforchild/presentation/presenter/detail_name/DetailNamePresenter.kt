package ru.ernestoguevara.nameforchild.presentation.presenter.detail_name

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.entities.Name
import ru.ernestoguevara.nameforchild.presentation.App
import ru.ernestoguevara.nameforchild.presentation.presenter.BasePresenter
import ru.ernestoguevara.nameforchild.repositories.NameRepository
import javax.inject.Inject

@InjectViewState
class DetailNamePresenter : BasePresenter<DetailNameView> {

    private val TAG = DetailNamePresenter::class.java.simpleName

    @Inject
    lateinit var nameRepo: NameRepository

    var selectedNameId: Long? = null
    var selectedName: Name? = null

    constructor() {
        App.instance.appComponent.inject(this)
    }

    fun getName() {
        viewState.startGetData()
        nameRepo.getByIdAsync(selectedNameId!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                selectedName = it
                viewState.stopGetData()
                viewState.showData()
            },{
                viewState.stopGetData()
                viewState.showError(R.string.load_error_name)
            })
    }

}