package ru.ernestoguevara.nameforchild.presentation.presenter.by_zodiac_sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.presentation.App
import ru.ernestoguevara.nameforchild.databinding.FragmentByZodiacSignBinding
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseFragment
import ru.ernestoguevara.nameforchild.presentation.presenter.adapter.NameAdapter
import javax.inject.Inject


class ByZodiacSignFragment : BaseFragment(), ByZodiacSignView {

    private lateinit var binding: FragmentByZodiacSignBinding

    @InjectPresenter
    lateinit var presenter: ByZodiacSignPresenter

    @Inject
    lateinit var adapter: NameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentByZodiacSignBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.instance.appComponent.inject(this)
        presenter.selectedZodiacSign = arguments?.getString("zodiacSign").toString()
        presenter.getNames()
    }

    override fun startGetData() {
    }

    override fun stopGetData() {
    }

    override fun showError(message: Int) {
    }

    override fun showData() {
        binding.names?.layoutManager = LinearLayoutManager(view?.context)

        adapter.onItemClick = { item ->
            presenter.selectedName = item
            presenter.goToDetailNameView(R.id.action_byLetterFragment_to_detailNameFragment)
        }
        adapter.setData(presenter.names)
        binding.names.adapter = adapter
    }

    override fun goToView(actionId: Int) {
    }


}