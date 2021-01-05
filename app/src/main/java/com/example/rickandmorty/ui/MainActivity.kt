package com.example.rickandmorty.ui

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.rickandmorty.R
import com.example.rickandmorty.adapter.CharactersGridAdapter
import com.example.rickandmorty.adapter.CustomAdapter
import com.example.rickandmorty.data.MyViewModel
import com.example.rickandmorty.data.database.MyDatabase
import com.example.rickandmorty.model.Characters
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var characterAdapter: CustomAdapter
    lateinit var characterGridAdapter: CharactersGridAdapter
    var mList: ArrayList<Characters> = ArrayList()
    lateinit var viewModel: MyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        characterAdapter = CustomAdapter(this, mList)
        characterGridAdapter = CharactersGridAdapter(this, mList)

        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        init()
    }

    private fun init() {
        //getDataFromApi()
        getDataFromDB()

        val currentOrientation = resources.configuration.orientation
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            setupRecyclerViewGrid()
        } else {
            setupRecyclerView()
        }

    }

    private fun setupRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = characterAdapter
    }

    private fun setupRecyclerViewGrid() {

        recycler_view.layoutManager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)
        recycler_view.adapter = characterGridAdapter
    }

    private fun getDataFromDB() {

        viewModel.getCharactersFromDB(this).observe(this, {
            characterAdapter.setData(it)
            characterGridAdapter.setData(it)
        })
    }

    private fun getDataFromApi() {

        viewModel.getCharactersFromApi(this).observe(this, {
            characterAdapter.setData(it)
        })
    }


}