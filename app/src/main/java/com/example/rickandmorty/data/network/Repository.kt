package com.example.rickandmorty.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.model.RickAndMortyResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getCharacters():LiveData<ArrayList<Characters>>{
        var character = MutableLiveData<ArrayList<Characters>>()

        MyApi().getCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableSingleObserver<RickAndMortyResponse>(){
                override fun onSuccess(t: RickAndMortyResponse) {
                    character.value = t.results
                }

                override fun onError(e: Throwable) {
                    Log.d("abc", e.message!!)
                }

            })
        return character

    }
}