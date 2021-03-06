package com.example.test.edt_in_rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R

class EdtInRvAdapter(
        private val list: List<TypeModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_1 = 1
        const val TYPE_2 = 2
        const val TYPE_3 = 3
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> {
                ItemType1(inflater.inflate(R.layout.item_type_1, parent, false))
            }
            2 -> {
                ItemType2(inflater.inflate(R.layout.item_type_2, parent, false))
            }
            3 -> {
                ItemType3(inflater.inflate(R.layout.item_type_3, parent, false))
            }
            else -> {
                throw IllegalArgumentException("Unknown typed $viewType")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemType3) {
            holder.bind()
        }
    }

    override fun getItemCount() = list.size

    class ItemType1(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class ItemType2(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    class ItemType3(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val recyclerView: RecyclerView = itemView.findViewById(R.id.recyclerView)

        fun bind() {
            val childList = mutableListOf<String>()
            for (i in 1..10) {
                childList.add("$i")
            }
            recyclerView.apply {
                layoutManager = GridLayoutManager(itemView.context, 3, GridLayoutManager.HORIZONTAL, false)
                adapter = RvInRvHaveEdtAdapter(childList)
            }
        }

    }

}