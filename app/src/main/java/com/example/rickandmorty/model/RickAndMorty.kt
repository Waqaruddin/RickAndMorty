package com.example.rickandmorty.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class RickAndMortyResponse(
    val info: Info,
    val results: ArrayList<Characters>
):Serializable

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
):Serializable

@Entity
data class Characters(
    val created: String,
  //  val episode: List<String>,
    val gender: String,
    @PrimaryKey
    val id: Int,

    val image: String,
   // val location: Location,
    val name: String,
    //val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
):Serializable

data class Location(
    val name: String,
    val url: String
):Serializable

data class Origin(
    val name: String,
    val url: String
):Serializable