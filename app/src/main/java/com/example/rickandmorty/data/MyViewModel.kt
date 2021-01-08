package com.example.rickandmorty.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.network.Repository
import com.example.rickandmorty.model.Characters

class MyViewModel : ViewModel() {

    fun getCharactersFromApi(context: Context):LiveData<List<Characters>>{
        return Repository().getCharacters(context)
    }

    fun getCharactersFromDB(context: Context):LiveData<List<Characters>>{
        return Repository().readData(context)
    }
}