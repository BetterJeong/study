package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel(count: Int) : ViewModel() {
    val countLiveData = MutableLiveData<Int>()

    init {
        countLiveData.value = count
    }

    fun increaseCount() {
        countLiveData.value = (countLiveData.value ?: 0) + 1
    }

    fun decreaseCount() {
        countLiveData.value = (countLiveData.value ?: 0) - 1
    }
}