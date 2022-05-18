package ru.ernestoguevara.nameforchild.presentation.presenter.by_letter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.databinding.FragmentByLetterSelectBinding
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseFragment
import ru.ernestoguevara.nameforchild.presentation.presenter.by_letter.adapter.LetterAdapter


class ByLetterSelectFragment : BaseFragment(), ByLetterSelectView {

    private lateinit var binding: FragmentByLetterSelectBinding

    @InjectPresenter
    lateinit var presenter: ByLetterSelectPresenter

    private lateinit var adapter: LetterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentByLetterSelectBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = context?.let { ita -> LetterAdapter(ita,R.layout.letter_item) }!!
        adapter.onItemClick = { it ->
            presenter.selectedLetter = it
            presenter.goToByLetterView(R.id.action_byLetterSelectFragment_to_byLetterFragment)
        }
        binding.letters.adapter = adapter

        super.onViewCreated(view, savedInstanceState)
    }

    override fun goToView(actionId: Int) {
        val bundle = Bundle().also {
            it.putString("letter", presenter.selectedLetter)
        }

        findNavController().navigate(actionId,bundle)
    }

}