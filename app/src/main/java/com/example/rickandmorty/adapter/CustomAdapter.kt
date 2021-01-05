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
import kotlinx.android.synthetic.main.row_adapter_characters.view.*

class CustomAdapter(var mContext: Context, var mList: List<Characters>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(characters: Characters) {
            itemView.text_view_name.text = characters.name
            Picasso.get()
                .load(characters.image)
                .into(itemView.image_view)

            itemView.setOnClickListener{
                var intent = Intent(mContext, CharacterDetailsActivity::class.java )
                intent.putExtra("key", characters)
                mContext.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view =
            LayoutInflater.from(mContext).inflate(R.layout.row_adapter_characters, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var character = mList[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(l:List<Characters>){
        mList = l
        notifyDataSetChanged()
    }
}