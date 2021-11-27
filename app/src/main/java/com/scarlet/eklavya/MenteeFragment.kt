package com.scarlet.eklavya

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.scarlet.eklavya.adapters.TextViewAdapter

class MenteeFragment : Fragment() {

    private lateinit var intrestView : RecyclerView
    private lateinit var skillsView : RecyclerView
    private lateinit var intrestAdapter : TextViewAdapter
    private lateinit var skillsAdapter: TextViewAdapter
    private lateinit var doneBtn : Button

    private lateinit var intrestList : Array<String>
    private lateinit var skillsList : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mentee, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View){
        intrestView = view.findViewById(R.id.intrestsView)
        skillsView = view.findViewById(R.id.skillsView)
        doneBtn = view.findViewById(R.id.doneBtnMentee)

        doneBtn.setOnClickListener {
            startActivity(Intent(this.context,HomeActivity::class.java))
        }

        intrestList = resources.getStringArray(R.array.intrests)
        skillsList = resources.getStringArray(R.array.skills)
        setRecyclerView()
    }

    private fun setRecyclerView(){

        val layoutManager1 = FlexboxLayoutManager(this.context)
        layoutManager1.flexDirection = FlexDirection.ROW
        intrestView.layoutManager = layoutManager1
        intrestAdapter = TextViewAdapter(intrestList.toList())
        intrestView.adapter = intrestAdapter

        val layoutManager2 = FlexboxLayoutManager(this.context)
        layoutManager1.flexDirection = FlexDirection.ROW
        skillsView.layoutManager = layoutManager2
        skillsAdapter = TextViewAdapter(skillsList.toList())
        skillsView.adapter = skillsAdapter
    }

}