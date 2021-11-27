package com.scarlet.eklavya.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.scarlet.eklavya.R
import com.scarlet.eklavya.data.Topic

class TopicsAdapter(private val list : List<Topic>) : RecyclerView.Adapter<TopicsAdapter.TopicViewHolder>() {

    private lateinit var title : TextView
    private lateinit var image : ImageView
    private lateinit var context : Context

    class TopicViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = (LayoutInflater.from(parent.context).inflate(R.layout.listview_blogs,parent,false))
        title = view.findViewById(R.id.titleTopic)
        image = view.findViewById(R.id.imageTopic)
        context = view.context
        val viewHolder = TopicViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        list[position].title.let { title.text = it }
        Glide.with(context)
            .load(list[position].image)
            .into(image)
    }

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long = position.hashCode().toLong()
}