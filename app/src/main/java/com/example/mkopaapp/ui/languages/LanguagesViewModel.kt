package com.example.mkopaapp.ui.languages

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LanguagesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is languages Fragment"
    }
    val text: LiveData<String> = _text
}