package com.example.dialog_alertdialog

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dialog_alertdialog.databinding.ActivityListGridViewBinding

class ListGirdViewActivity: AppCompatActivity() {
    private val mutablelist = mutableListOf<String>()
    private lateinit var binding: ActivityListGridViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpdataMutable()
        setUpDataListView()
        setUpdataGirdView()
        setUpListenerClickToRecyclerView()
    }

    private fun setUpListenerClickToRecyclerView() {
        binding.btnToRecylerView.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpdataGirdView() {
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, mutablelist)
        binding.gridView.adapter = adapter
    }


    private fun setUpDataListView() {
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, mutablelist)
        binding.listView.adapter = adapter
    }

    fun setUpdataMutable() {
        mutablelist.add("Việt Nam")
        mutablelist.add("Campuchia")
        mutablelist.add("Lào")
        mutablelist.add("Trung Quốc")
        mutablelist.add("Hoa kỳ")
    }
}