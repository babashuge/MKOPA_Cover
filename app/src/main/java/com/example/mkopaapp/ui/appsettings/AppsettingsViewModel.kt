package com.example.mkopaapp.ui.appsettings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppsettingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "App Settings"
    }
    val text: LiveData<String> = _text
}