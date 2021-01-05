package com.example.rickandmorty.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.model.Characters

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacter(character:Characters)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacterList(characters:List<Characters>)

    @Query("select * from Characters")
    fun readCharacters():LiveData<List<Characters>>
}