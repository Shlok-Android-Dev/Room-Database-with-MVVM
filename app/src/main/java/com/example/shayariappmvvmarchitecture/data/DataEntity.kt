package com.example.shayariappmvvmarchitecture.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "shayari_table")
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int = 0,
    @ColumnInfo(name = "Date")
    var date: Date,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "Shayari")
    var shayari: String,
)
