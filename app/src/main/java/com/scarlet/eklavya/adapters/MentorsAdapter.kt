package com.scarlet.eklavya.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.scarlet.eklavya.R
import com.scarlet.eklavya.data.Mentor
import com.scarlet.eklavya.util.TopMentorsClickListner
import de.hdodenhof.circleimageview.CircleImageView

class MentorsAdapter(private val resourceLayout : Int, private val  list : List<Mentor>, private val listner : TopMentorsClickListner?) : RecyclerView.Adapter<MentorsAdapter.MentorsViewHolder>() {

    private lateinit var card : MaterialCardView
    private lateinit var image : CircleImageView
    private lateinit var name : TextView
    private lateinit var company : TextView
    private lateinit var followers : TextView
    private lateinit var context : Context

    class MentorsViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MentorsViewHolder {
        val view = (LayoutInflater.from(parent.context).inflate(resourceLayout,parent,false))
        card = view.findViewById(R.id.mentorProfile)
        image = view.findViewById(R.id.imageMentor)
        name = view.findViewById(R.id.nameMentor)
        company = view.findViewById(R.id.companyMentor)
        followers = view.findViewById(R.id.followersMentor)
        context = view.context
        val viewHolder = MentorsViewHolder(view)
        card.setOnClickListener {
            listner?.onRecyclerViewItemClick(viewHolder.adapterPosition)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MentorsViewHolder, position: Int) {
        list[position].name.let { name.text = it }
        list[position].company.let { company.text = it }
        list[position].followers.let { followers.text = it }
        Glide.with(context)
            .load(list[position].image)
            .into(image)
    }

    override fun getItemCount(): Int = list.size

    override fun getItemId(position: Int): Long = position.hashCode().toLong()
}