package com.example.task07

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task07.databinding.ItemLayoutBinding

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setContents(post: Int) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
        // val view = layoutInflater.inflate(R.layout.item_layout, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setContents(position)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}