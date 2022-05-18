package ru.ernestoguevara.nameforchild.presentation.presenter.by_zodiac_sign

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.presentation.App
import ru.ernestoguevara.nameforchild.entities.Name
import ru.ernestoguevara.nameforchild.usecases.GetNamesByZodiacSignUseCase
import ru.ernestoguevara.nameforchild.presentation.presenter.BasePresenter
import javax.inject.Inject

@InjectViewState
class ByZodiacSignPresenter : BasePresenter<ByZodiacSignView> {

    private val TAG = ByZodiacSignPresenter::class.java.simpleName

    @Inject
    lateinit var getNames: GetNamesByZodiacSignUseCase

    lateinit var selectedZodiacSign: String
    lateinit var selectedName: Name

    lateinit var names: List<Name>

    constructor() {
        App.instance.appComponent.inject(this)
    }

    fun getNames() {
        viewState.startGetData()
        addSubscript(
            getNames.invoke(selectedZodiacSign).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    names = it
                    viewState.stopGetData()
                    viewState.showData()
                }, {
                    viewState.stopGetData()
                    viewState.showError(R.string.load_error_names)
                })
        )
    }

    fun goToDetailNameView(actionId: Int) {
        viewState.goToView(actionId)
    }

}