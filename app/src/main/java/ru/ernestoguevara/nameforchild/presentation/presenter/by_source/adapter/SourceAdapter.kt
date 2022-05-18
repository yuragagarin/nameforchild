package ru.ernestoguevara.nameforchild.presentation.presenter.by_source.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class SourceAdapter(context: Context, private val layoutResource: Int) : ArrayAdapter<String>(context, layoutResource) {

    private var items
        = arrayOf("Арабские", "Английские", "Германские", "Греческие", "Еврейские", "Кельтские",
        "Латинские", "Персидские", "Скандинавские", "Старославянские", "Тюрские"
    )

    var onItemClick: ((String) -> Unit)? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: TextView = convertView as TextView? ?: LayoutInflater.from(context).inflate(layoutResource,parent,false) as TextView
        val item = getItem(position)
        view?.setText(item)

        view.setOnClickListener {
            onItemClick?.invoke(items.get(position))
        }

        return view
    }

    override fun getItem(position: Int) : String {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }
}