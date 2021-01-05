package com.example.rickandmorty.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmorty.model.Characters


@Database(entities = [Characters::class], version = 1)
abstract class MyDatabase:RoomDatabase(){
    abstract fun getDao():MyDao

    companion object {
        fun getRoomDbInstance(appContext: Context): MyDatabase {
            return Room.databaseBuilder(appContext, MyDatabase::class.java, "character_table")
                    //.fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
        }
    }
}