package com.example.rickandmorty.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entity(

  @PrimaryKey
  var id:Int,
  var name:String? = null
)