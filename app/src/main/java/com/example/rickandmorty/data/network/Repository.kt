package com.example.rickandmorty.data.network

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.rickandmorty.data.database.MyDatabase
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.model.RickAndMortyResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    var character = MutableLiveData<List<Characters>>()

    fun getCharacters(context: Context): LiveData<List<Characters>> {

        MyApi().getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<RickAndMortyResponse>() {
                    override fun onSuccess(t: RickAndMortyResponse) {
                        character.value = t.results
                        storeCharacters(t.results, context)

                    }

                    override fun onError(e: Throwable) {
                        Log.d("abc", e.message!!)
                    }

                })
        return character

    }

    fun saveData(app: Application) {
        var db = Room.databaseBuilder(app, MyDatabase::class.java, "mydb")
                .allowMainThreadQueries()
                .build()

        db.getDao().insertCharacterList(character as List<Characters>)

    }

    private fun storeCharacters(characterList: ArrayList<Characters>, context: Context) {
        MyDatabase.getRoomDbInstance(context).getDao().insertCharacterList(characterList)
    }

    fun readData(context: Context): LiveData<List<Characters>> {
       return MyDatabase.getRoomDbInstance(context).getDao().readCharacters()

    }

}