package com.example.rickandmorty.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.network.Repository
import com.example.rickandmorty.model.Characters

class MyViewModel : ViewModel() {
    fun getCharacter(): LiveData<ArrayList<Characters>> {
        return Repository().getCharacters()
    }
}