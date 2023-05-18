package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val viewModel: MyViewModel) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setContents(pos: Int) {
            val textView = view.findViewById<TextView>(R.id.textView)
            val textView2 = view.findViewById<TextView>(R.id.textView2)
            with (viewModel.items[pos]) {
                textView.text = firstName
                textView2.text = lastName
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater.inflate(R.layout.item_layout, viewGroup, false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener {
            viewModel.itemClickEvent.value = viewHolder.adapterPosition
        }
        view.setOnLongClickListener {
            viewModel.itemLongClick = viewHolder.adapterPosition
            false
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return viewModel.items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.setContents(position)
    }

}