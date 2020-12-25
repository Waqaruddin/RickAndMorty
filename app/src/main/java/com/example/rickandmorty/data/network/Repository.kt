package com.example.rickandmorty.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getCharacters():LiveData<ArrayList<Characters>>{
        var character = MutableLiveData<ArrayList<Characters>>()


        MyApi().getCharacters()
            .enqueue(object : Callback<RickAndMortyResponse>{
                override fun onResponse(
                    call: Call<RickAndMortyResponse>,
                    response: Response<RickAndMortyResponse>
                ) {
                    character.value = response.body()!!.results
                    Log.d("abc", response.body().toString())
                }

                override fun onFailure(call: Call<RickAndMortyResponse>, t: Throwable) {
                    Log.d("abc", t.message.toString())
                }

            })

        return character

    }
}