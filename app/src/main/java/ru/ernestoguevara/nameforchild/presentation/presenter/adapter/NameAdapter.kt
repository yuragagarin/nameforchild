package ru.ernestoguevara.nameforchild.presentation.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.ernestoguevara.nameforchild.R
import ru.ernestoguevara.nameforchild.entities.Name

class NameAdapter : RecyclerView.Adapter<NameAdapter.ViewHolder>() {

    private var data: ArrayList<Name> = ArrayList()
    var onItemClick: ((Name) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(viewGroup.context).inflate(R.layout.by_letter_item, viewGroup, false);
        return ViewHolder(v);
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var name = data[position];
        viewHolder.name.setText(name.value);
        viewHolder.source.setText(name.source);
        viewHolder.meaning.setText(name.meaning);
        if(name.sex == "m")
            viewHolder.sex.setImageResource(R.drawable.ic_boy)
        else
            viewHolder.sex.setImageResource(R.drawable.ic_girl)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(items: List<Name>) {
        this.data.apply {
            clear()
            addAll(items)
        }
    }

    private fun clear() {
        this.data.apply {
            clear()
        }
    }

    inner class ViewHolder : RecyclerView.ViewHolder {

        var name: TextView
        var source: TextView
        var meaning: TextView
        var sex: ImageView

        constructor(itemView: View) : super(itemView) {
            name = itemView.findViewById(R.id.name) as TextView
            source = itemView.findViewById(R.id.source) as TextView
            meaning = itemView.findViewById(R.id.meaning) as TextView
            sex = itemView.findViewById(R.id.sex_img) as ImageView
            itemView.setOnClickListener {
                onItemClick?.invoke(data.get(adapterPosition))
            }
        }

    }


}