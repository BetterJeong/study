package com.example.task04

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val myValue = MutableLiveData<String>()

    init {
        myValue.value = "0"
    }
}