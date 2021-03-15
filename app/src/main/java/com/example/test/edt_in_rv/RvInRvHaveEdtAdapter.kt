package com.example.test.edt_in_rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R


class RvInRvHaveEdtAdapter(
        private val list: List<String>
) : RecyclerView.Adapter<RvInRvHaveEdtAdapter.TitleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_child_type_3, parent, false)
        return TitleHolder(v)
    }

    override fun onBindViewHolder(holder: TitleHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    class TitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.tv)

        fun bind(title: String) {
            textView.text = title
        }
    }

}