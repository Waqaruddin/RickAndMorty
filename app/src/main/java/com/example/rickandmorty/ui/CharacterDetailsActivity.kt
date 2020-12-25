package com.example.rickandmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Characters
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_character_details.*

class CharacterDetailsActivity : AppCompatActivity() {

    var character:Characters? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        character = intent.getSerializableExtra("key") as Characters

        init()
    }

    private fun init() {

        Picasso.get()
            .load(character!!.image)
            .resize(1000, 500)
            .into(image_view)
        text_view_name.text = character!!.name
        text_view_species.text = character!!.species
        text_view_status.text = character!!.status
        text_view_gender.text = character!!.gender

    }
}