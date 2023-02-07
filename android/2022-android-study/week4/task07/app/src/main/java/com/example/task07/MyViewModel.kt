package com.example.task07

import androidx.lifecycle.ViewModel

data class Item(val name: String, val phone: String)

class MyViewModel : ViewModel() {
    val items = ArrayList<Item>()

    fun addItem(item: Item) {
        items.add(item)
    }
}