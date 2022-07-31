package com.example.mkopaapp.ui.howto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HowtoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "How to frag"
    }
    val text: LiveData<String> = _text
}