package com.example.rickandmorty.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmorty.model.Characters


@Database(entities = [Characters::class], version = 1)
abstract class MyDatabase:RoomDatabase(){
    abstract fun getDao():MyDao
}