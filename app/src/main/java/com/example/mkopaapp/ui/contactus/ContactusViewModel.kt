package com.example.mkopaapp.ui.contactus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactusViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is contactUs Fragment"
    }
    val text: LiveData<String> = _text
}