package com.example.task07

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Item(val name: String, val phone: String)

class MyViewModel : ViewModel() {
    val items = ArrayList<Item>()
    val itemsLiveData = MutableLiveData<ArrayList<Item>>()

    var longClickItem: Int = -1
    var changedItemPos = -1

    init {
        addItem(Item("james", "1234"))
        addItem(Item("tom", "12345"))
    }

    fun addItem(item: Item) {
        items.add(item)
        itemsLiveData.value = items
    }

    fun updateItem(item: Item, pos: Int) {
        items[pos] = item
        itemsLiveData.value = items
        changedItemPos = pos
    }
}