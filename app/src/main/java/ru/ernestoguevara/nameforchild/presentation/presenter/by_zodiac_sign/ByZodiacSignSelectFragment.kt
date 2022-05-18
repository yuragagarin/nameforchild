package ru.ernestoguevara.nameforchild.presentation.presenter.by_zodiac_sign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.databinding.FragmentByZodiacSignSelectBinding
import ru.ernestoguevara.nameforchild.presentation.presenter.BaseFragment
import ru.ernestoguevara.nameforchild.presentation.presenter.by_zodiac_sign.adapter.ZodiacSignAdapter


class ByZodiacSignSelectFragment : BaseFragment(), ByZodiacSignSelectView {

    private lateinit var binding: FragmentByZodiacSignSelectBinding

    @InjectPresenter
    lateinit var presenter: ByZodiacSignSelectPresenter

    private lateinit var adapter: ZodiacSignAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentByZodiacSignSelectBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = context?.let { ita -> ZodiacSignAdapter(ita,R.layout.zodiac_sign_item) }!!
        adapter.onItemClick = { it ->
            presenter.selected = it
            presenter.goToByZodiacSignView(R.id.action_byZodiacSignSelectFragment_to_byZodiacSignFragment)
        }
        binding.zodiacSigns.adapter = adapter

        super.onViewCreated(view, savedInstanceState)
    }

    override fun goToView(actionId: Int) {
        val bundle = Bundle().also {
            it.putString("zodiacSign", presenter.selected)
        }

        findNavController().navigate(actionId,bundle)
    }


}