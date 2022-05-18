package ru.ernestoguevara.nameforchild.presentation.presenter.by_source

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.databinding.FragmentBySourceSelectBinding
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseFragment
import ru.ernestoguevara.nameforchild.presentation.presenter.by_source.adapter.SourceAdapter


class BySourceSelectFragment : BaseFragment(), BySourceSelectView {

    private lateinit var binding: FragmentBySourceSelectBinding

    @InjectPresenter
    lateinit var presenter: BySourceSelectPresenter

    private lateinit var adapter: SourceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBySourceSelectBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = context?.let { ita -> SourceAdapter(ita, R.layout.source_item) }!!
        adapter.onItemClick = { it ->
            presenter.selected = it
            presenter.goToBySourceView(R.id.action_bySourceSelectFragment_to_bySourceFragment)
        }
        binding.sources.adapter = adapter

        super.onViewCreated(view, savedInstanceState)
    }

    override fun goToView(actionId: Int) {
        val bundle = Bundle().also {
            it.putString("source", presenter.selected)
        }

        findNavController().navigate(actionId,bundle)
    }

}