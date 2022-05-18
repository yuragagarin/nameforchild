package ru.ernestoguevara.nameforchild.presentation.presenter.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.databinding.FragmentMainBinding
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseFragment


class MainFragment : BaseFragment(), MainView {

    private lateinit var binding: FragmentMainBinding

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
    }

    private fun setupUi() {
        binding.byLetter.setOnClickListener {
            mainPresenter.goToView(R.id.action_mainFragment_to_byLetterSelectFragment)
        }
        binding.byZodiacSign.setOnClickListener {
            mainPresenter.goToView(R.id.action_mainFragment_to_byZodiacSignSelectFragment)
        }
        binding.bySource.setOnClickListener {
            mainPresenter.goToView(R.id.action_mainFragment_to_bySourceSelectFragment)
        }
    }

    override fun goToView(actionId: Int) {
        findNavController().navigate(actionId)
    }

}