package com.example.dialog_alertdialog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dialog_alertdialog.databinding.ItemGirdViewBinding

class GirdAdapter: RecyclerView.Adapter<GirdAdapter.ViewHolder>() {
    private val listData = mutableListOf<String>()
    class ViewHolder(val binding: ItemGirdViewBinding):RecyclerView.ViewHolder(binding.root)

    fun setData(data: MutableList<String>){
        this.listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemGirdViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvItemRecyclerView.text = listData[position]
    }

    override fun getItemCount(): Int =listData.size
}