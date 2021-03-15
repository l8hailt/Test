package com.example.test.edt_in_rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R

class EdtInRvActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edt_in_rv)

        val list = mutableListOf<TypeModel>()
        list.add(TypeModel("", EdtInRvAdapter.TYPE_1))
        list.add(TypeModel("", EdtInRvAdapter.TYPE_2))
        list.add(TypeModel("", EdtInRvAdapter.TYPE_1))
        list.add(TypeModel("", EdtInRvAdapter.TYPE_2))
        list.add(TypeModel("", EdtInRvAdapter.TYPE_1))
        list.add(TypeModel("", EdtInRvAdapter.TYPE_1))
        list.add(TypeModel("", EdtInRvAdapter.TYPE_3))
        list.add(TypeModel("", EdtInRvAdapter.TYPE_2))
        val adapter = EdtInRvAdapter(list)
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            this.adapter = adapter
        }

    }
}