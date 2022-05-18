package ru.ernestoguevara.nameforchild.presentation.presenter.by_zodiac_sign.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class ZodiacSignAdapter(context: Context, private val layoutResource: Int) : ArrayAdapter<String>(context, layoutResource) {

    private var letters
        = arrayOf("Козерог", "Водолей", "Рыбы", "Овен", "Телец", "Близнецы", "Рак",
        "Лев", "Дева", "Весы", "Скорпион", "Стрелец"
    )

    var onItemClick: ((String) -> Unit)? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: TextView = convertView as TextView? ?: LayoutInflater.from(context).inflate(layoutResource,parent,false) as TextView
        val item = getItem(position)
        view?.setText(item)

        view.setOnClickListener {
            onItemClick?.invoke(letters.get(position))
        }

        return view
    }

    override fun getItem(position: Int) : String {
        return letters[position]
    }

    override fun getCount(): Int {
        return letters.size
    }
}