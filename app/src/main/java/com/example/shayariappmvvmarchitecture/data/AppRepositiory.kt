package com.example.shayariappmvvmarchitecture.data

import androidx.lifecycle.LiveData
import com.example.shayariappmvvmarchitecture.presentation.viewmodel.ShayariViewModel

class ShayariRepository(private val shayariDao: ShayariDao) {

    fun getAllShayari(): LiveData<List<DataEntity>> {
        return shayariDao.getAllSharari()
    }

    suspend fun insertShayari(dataEntity: DataEntity) {
        shayariDao.insetShayari(dataEntity)
    }
    suspend fun deleteShayari(dataEntity: DataEntity) {
        shayariDao.deleterShayari(dataEntity)
    }
    suspend fun updateShayari(dataEntity: DataEntity) {
        shayariDao.updateShayari(dataEntity)
    }

}
