package com.example.rickandmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.adapter.CustomAdapter
import com.example.rickandmorty.data.MyViewModel
import com.example.rickandmorty.model.Characters
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var characterAdapter:CustomAdapter? = null
    var mList:ArrayList<Characters> = ArrayList()
    lateinit var viewModel:MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        init()
    }

    private fun init() {
        getData()
        characterAdapter = CustomAdapter(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = characterAdapter
    }

    private fun getData() {
        viewModel.getCharacter().observe(this, {
            characterAdapter!!.setData(it)
        })
    }
}