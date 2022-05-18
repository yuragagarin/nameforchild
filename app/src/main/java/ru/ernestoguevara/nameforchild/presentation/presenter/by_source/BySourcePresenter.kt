package ru.ernestoguevara.nameforchild.presentation.presenter.by_source

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.presentation.App
import ru.ernestoguevara.nameforchild.entities.Name
import ru.ernestoguevara.nameforchild.usecases.GetNamesBySourceUseCase
import ru.ernestoguevara.nameforchild.presentation.presenter.BasePresenter
import javax.inject.Inject

@InjectViewState
class BySourcePresenter: BasePresenter<BySourceView> {

    private val TAG = BySourcePresenter::class.java.simpleName

    @Inject
    lateinit var getNames: GetNamesBySourceUseCase

    lateinit var selectedSource: String
    lateinit var selectedName: Name

    lateinit var names: List<Name>

    constructor() {
        App.instance.appComponent.inject(this)
    }

    fun getNames() {
        viewState.startGetData()
        addSubscript(getNames.invoke(selectedSource).subscribeOn(Schedulers.io())
            //.delay(2,TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                names = it
                viewState.stopGetData()
                viewState.showData()
            },{
                viewState.stopGetData()
                viewState.showError(R.string.load_error_names)
            })
        )
    }

    fun goToDetailNameView(actionId: Int) {
        viewState.goToView(actionId)
    }

}