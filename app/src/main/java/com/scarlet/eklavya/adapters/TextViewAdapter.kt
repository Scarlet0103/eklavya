package com.scarlet.eklavya.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.scarlet.eklavya.R

class TextViewAdapter(val list : List<String>) : RecyclerView.Adapter<TextViewAdapter.TextViewHolder>(){

    private lateinit var textView : TextView

    class TextViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = (LayoutInflater.from(parent.context).inflate(R.layout.viewitem_text,parent,false))
        val viewHolder = TextViewHolder(view)
        textView = view.findViewById(R.id.itemViewText)
        return viewHolder
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        textView.text = list[position]
    }

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long  = position.hashCode().toLong()
}