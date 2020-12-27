package com.example.rickandmorty.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rickandmorty.model.Characters

@Dao
interface MyDao {

    @Insert
    fun addCharacter(character:Characters)

    @Query("select * from Characters")
    fun readCharacter():LiveData<List<Characters>>
}