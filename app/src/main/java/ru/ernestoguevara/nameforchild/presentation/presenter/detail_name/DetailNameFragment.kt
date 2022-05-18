package ru.ernestoguevara.nameforchild.presentation.presenter.detail_name

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.ernestoguevara.nameforchild.presentation.App
import ru.ernestoguevara.nameforchild.databinding.FragmentDetailNameBinding
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseFragment

class DetailNameFragment : BaseFragment(), DetailNameView {

    private lateinit var binding: FragmentDetailNameBinding

    @InjectPresenter
    lateinit var presenter: DetailNamePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailNameBinding.inflate(inflater).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.instance.appComponent.inject(this)
        presenter.selectedNameId = arguments?.getLong("nameId")
        presenter.getName()
    }

    override fun startGetData() {
        binding.progressLayout.progressView.startAnimation()
        binding.progressLayout.progressView.visibility = View.VISIBLE
    }

    override fun stopGetData() {
        binding.progressLayout.progressView.stopAnimation()
        binding.progressLayout.progressView.visibility = View.GONE
    }

    override fun showError(message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun showData() {

    }


}