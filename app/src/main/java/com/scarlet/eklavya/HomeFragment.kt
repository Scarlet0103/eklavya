package com.scarlet.eklavya

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scarlet.eklavya.adapters.MentorsAdapter
import com.scarlet.eklavya.adapters.TopicsAdapter
import com.scarlet.eklavya.data.Mentor
import com.scarlet.eklavya.data.Topic

class HomeFragment : Fragment() {

    private lateinit var mentorsView : RecyclerView
    private lateinit var tipsView : RecyclerView
    private lateinit var recommendedView : RecyclerView
    private lateinit var trendingView : RecyclerView

    private lateinit var mentorsViewAdapter : MentorsAdapter
    private lateinit var recommendedViewAdapter: MentorsAdapter
    private lateinit var tipsViewAdapter: TopicsAdapter
    private lateinit var trendingViewAdapter : TopicsAdapter

    private var mentorsList : MutableList<Mentor> = mutableListOf()
    private var recommemdedList : MutableList<Mentor> = mutableListOf()
    private var tipsList : MutableList<Topic> = mutableListOf()
    private var trendingList : MutableList<Topic> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initView(view)
        return view
    }

    private fun initView(view : View){
        mentorsView = view.findViewById(R.id.mentorsView)
        mentorsView.isNestedScrollingEnabled = false
        tipsView = view.findViewById(R.id.tipsView)
        tipsView.isNestedScrollingEnabled = false
        recommendedView = view.findViewById(R.id.recommenedView)
        recommendedView.isNestedScrollingEnabled = false
        trendingView = view.findViewById(R.id.trendingTopicsView)
        trendingView.isNestedScrollingEnabled = false
        getData()
    }

    private fun getData(){
        mentorsList.add(Mentor("Samuel","Full-Stack Developer, Google","204 Followers",R.drawable.profile1))
        mentorsList.add(Mentor("Nancy","IOS Developer, Adobe","196 Followers",R.drawable.profile2))
        mentorsList.add(Mentor("Selena","AWS Developer, Amazon","135 Followers",R.drawable.profile3))

        recommemdedList.add(Mentor("Samuel","Full-Stack Developer, Google","204 Followers",R.drawable.profile1))
        recommemdedList.add(Mentor("Nancy","IOS Developer, Adobe","196 Followers",R.drawable.profile2))
        recommemdedList.add(Mentor("Selena","AWS Developer, Amazon","135 Followers",R.drawable.profile3))

        tipsList.add(Topic("How to start with android dev?",R.drawable.topic1))
        tipsList.add(Topic("Core principles in camera API jetpack",R.drawable.topic2))

        trendingList.add(Topic("React new version patch notes",R.drawable.topic3))
        trendingList.add(Topic("NLP program in new google app",R.drawable.topic4))

        addToRecyclerView()
    }

    private fun addToRecyclerView(){
        val layoutManager1 = LinearLayoutManager(activity?.baseContext,LinearLayoutManager.HORIZONTAL,false)
        mentorsViewAdapter = MentorsAdapter(R.layout.listview_mentors_hor,mentorsList,null)
        mentorsView.layoutManager = layoutManager1
        mentorsView.adapter = mentorsViewAdapter

        val layoutManager2 = LinearLayoutManager(activity?.baseContext,LinearLayoutManager.HORIZONTAL,false)
        tipsViewAdapter = TopicsAdapter(tipsList)
        tipsView.layoutManager = layoutManager2
        tipsView.adapter = tipsViewAdapter

        val layoutManager3 = LinearLayoutManager(activity?.baseContext,LinearLayoutManager.VERTICAL,false)
        recommendedViewAdapter = MentorsAdapter(R.layout.listview_mentors_vert,recommemdedList,null)
        recommendedView.layoutManager = layoutManager3
        recommendedView.adapter = recommendedViewAdapter

        val layoutManager4 = LinearLayoutManager(activity?.baseContext,LinearLayoutManager.HORIZONTAL,false)
        trendingViewAdapter = TopicsAdapter(trendingList)
        trendingView.layoutManager = layoutManager4
        trendingView.adapter = trendingViewAdapter
    }


}