package com.example.mkopaapp.ui.myAccount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyaccountViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is myAccount Fragment"
    }
    val text: LiveData<String> = _text
}