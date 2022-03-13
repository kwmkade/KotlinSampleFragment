package com.kwmkade.kotlinsamplefragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {

    val ITEMS = MutableLiveData<Item>()

    fun addItem(content: String) {
        ITEMS.value = Item(content)
    }

    data class Item(val content: String) {
        override fun toString(): String = content
    }
}