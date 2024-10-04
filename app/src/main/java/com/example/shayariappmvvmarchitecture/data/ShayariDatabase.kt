package com.example.shayariappmvvmarchitecture.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [DataEntity::class], version = 1, exportSchema = true)
@TypeConverters(DateConverter::class) // Registering the DateConverter
abstract class ShayariDatabase : RoomDatabase() {

    abstract fun getShayariDao(): ShayariDao

    companion object {
        @Volatile
        private var INSTANCE: ShayariDatabase? = null

        fun getDatabase(context: Context): ShayariDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShayariDatabase::class.java,
                    "shayari_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
