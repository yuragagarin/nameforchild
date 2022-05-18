package ru.ernestoguevara.nameforchild.presentation.presenter.by_letter

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.entities.Name
import ru.ernestoguevara.nameforchild.presentation.App
import ru.ernestoguevara.nameforchild.presentation.presenter.BasePresenter
import ru.ernestoguevara.nameforchild.usecases.GetNamesByLetterUseCase
import javax.inject.Inject

@InjectViewState
class ByLetterPresenter: BasePresenter<ByLetterView> {

    private val TAG = ByLetterPresenter::class.java.simpleName

    @Inject
    lateinit var getNames: GetNamesByLetterUseCase

    lateinit var selectedLetter: String
    lateinit var selectedName: Name

    lateinit var names: List<Name>

    constructor() {
        App.instance.appComponent.inject(this)
    }

    fun getNames() {
        viewState.startGetData()
        addSubscript(
            getNames.invoke(selectedLetter).subscribeOn(Schedulers.io())
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