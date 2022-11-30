package com.example.dialog_alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dialog_alertdialog.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private val mutablelist = mutableListOf<String>()
    private val girdAdapter: GirdAdapter by lazy { GirdAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpdataMutable()
        setDataAdapteView()
        setUpView()
    }
    private fun setUpView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = girdAdapter
        }
    }
    private fun setDataAdapteView() {
        girdAdapter.setData(mutablelist )
    }
    fun setUpdataMutable() {
        mutablelist.add("Việt Nam")
        mutablelist.add("Campuchia")
        mutablelist.add("Lào")
        mutablelist.add("Trung Quốc")
        mutablelist.add("Hoa kỳ")
    }
}