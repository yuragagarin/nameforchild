package ru.ernestoguevara.nameforchild.presentation.presenter.by_source

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.ernestoguevara.nameforchild.presentation.App
import ru.ernestoguevara.nameforchild.databinding.FragmentBySourceBinding
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseFragment
import ru.ernestoguevara.nameforchild.presentation.presenter.adapter.NameAdapter
import javax.inject.Inject

class BySourceFragment : BaseFragment(), BySourceView {

    private lateinit var binding: FragmentBySourceBinding

    @InjectPresenter
    lateinit var presenter: BySourcePresenter

    @Inject
    lateinit var adapter: NameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBySourceBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.instance.appComponent.inject(this)
        presenter.selectedSource = arguments?.getString("source").toString()
        presenter.getNames()
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
        binding.names?.layoutManager = LinearLayoutManager(view?.context)

        adapter.onItemClick = { item ->
            presenter.selectedName = item
        }
        adapter.setData(presenter.names)
        binding.names.adapter = adapter
    }

    override fun goToView(actionId: Int) {
        val bundle = Bundle().also {
            it.putLong("nameId", presenter.selectedName.id)
        }
        findNavController().navigate(actionId,bundle)
    }


}