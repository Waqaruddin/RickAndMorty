//package com.example.rickandmorty.data.database
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import com.example.rickandmorty.model.Characters
//
//@Dao
//interface DAO {
//
//    @Insert
//    fun addCharacter(character:Characters)
//
//    @Query("select * from char_table")
//    fun readCharacter():LiveData<ArrayList<Characters>>
//}