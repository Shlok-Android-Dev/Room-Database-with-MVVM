package com.example.shayariappmvvmarchitecture.data

import androidx.activity.result.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ShayariDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insetShayari(dataEntity: DataEntity)

    @Delete
    suspend fun deleterShayari(dataEntity: DataEntity)

    @Update
    suspend fun updateShayari(dataEntity: DataEntity)

    @Query("select * FROM shayari_table order by date desc")
    fun getAllSharari():LiveData<List<DataEntity>>



}
