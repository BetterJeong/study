package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Item(val firstName: String, val lastName: String)

class MyViewModel : ViewModel() {
    val itemsListData = MutableLiveData<ArrayList<Item>>()
    val items = ArrayList<Item>()
    val itemClickEvent = MutableLiveData<Int>()
    var itemLongClick = -1

    fun addItem(item: Item) {
        items.add(item)
        itemsListData.value = items
    }
    fun updateItem(pos: Int, item: Item) {
        items[pos] = item
        itemsListData.value = items
    }
    fun deleteItem(pos: Int) {
        items.removeAt(pos)
        itemsListData.value = items
    }

}