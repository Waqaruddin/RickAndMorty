package com.example.rickandmorty.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.ui.CharacterDetailsActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_character_grid.view.*
import kotlinx.android.synthetic.main.row_adapter_characters.view.*
import kotlinx.android.synthetic.main.row_adapter_characters.view.text_view_name
import kotlin.coroutines.coroutineContext


class CharactersGridAdapter(var context: Context, var mList: List<Characters>) : RecyclerView.Adapter<CharactersGridAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(character: Characters) {
            itemView.text_view_name.text = character.name
           Picasso.get()
                   .load(character.image)
                   .into(itemView.image_view_grid)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_character_grid, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var character = mList[position]
        return holder.bind(character)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(l:List<Characters>){
        mList = l
        notifyDataSetChanged()
    }
}