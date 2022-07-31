package com.example.mkopaapp.ui.servcenters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ServcentersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Service centers" +
                ""
    }
    val text: LiveData<String> = _text
}