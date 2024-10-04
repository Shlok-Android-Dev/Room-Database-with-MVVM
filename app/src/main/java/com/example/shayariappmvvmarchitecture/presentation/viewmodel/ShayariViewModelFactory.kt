package com.example.shayariappmvvmarchitecture.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShayariViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShayariViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ShayariViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
