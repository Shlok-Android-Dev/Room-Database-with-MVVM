package com.example.shayariappmvvmarchitecture.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.shayariappmvvmarchitecture.data.DataEntity
import com.example.shayariappmvvmarchitecture.data.ShayariDao
import com.example.shayariappmvvmarchitecture.data.ShayariRepository
import com.example.shayariappmvvmarchitecture.data.ShayariDatabase
import kotlinx.coroutines.launch

class ShayariViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ShayariRepository
    val allShayari: LiveData<List<DataEntity>>


    init {
        // Initialize the ShayariRepository using the Application context
        val shayariDao = ShayariDatabase.getDatabase(application).getShayariDao()
        repository = ShayariRepository(shayariDao)
        allShayari = repository.getAllShayari()
    }

    fun insertShayari(dataEntity: DataEntity) = viewModelScope.launch {
        repository.insertShayari(dataEntity)

    }


}
