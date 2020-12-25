package com.example.rickandmorty.data.network

import com.example.rickandmorty.model.RickAndMortyResponse
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("?page=1/")
    fun getCharacters(): Single<RickAndMortyResponse>

    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/character/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}