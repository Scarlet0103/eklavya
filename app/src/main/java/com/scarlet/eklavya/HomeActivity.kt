package com.scarlet.eklavya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.scarlet.eklavya.adapters.MentorsAdapter
import com.scarlet.eklavya.data.Mentor
import com.scarlet.eklavya.util.TopMentorsClickListner
import de.hdodenhof.circleimageview.CircleImageView

class HomeActivity : AppCompatActivity(), TopMentorsClickListner {

    private lateinit var bottomView : BottomNavigationView
    private lateinit var searchBar :  EditText
    private lateinit var searchLayout : FrameLayout
    private lateinit var trendingTopicLayout : LinearLayout
    private lateinit var topMentorsLayout : LinearLayout
    private lateinit var trendingTxt : TextView
    private lateinit var topMentorsTxt : TextView
    private lateinit var topMentorsView : RecyclerView
    private lateinit var bottomSheetDialog : BottomSheetDialog
    private lateinit var bottomSheetView : View

    private lateinit var topMentorsAdapter: MentorsAdapter
    private var mentorsList : MutableList<Mentor> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportFragmentManager.beginTransaction()
            .add(R.id.homeFragmentContainer,HomeFragment())
            .commit()
        initView()
        getData()
    }

    private fun initView(){
        bottomView = findViewById(R.id.homeBottomNav)
        bottomView.selectedItemId = R.id.navHome

        searchBar = findViewById(R.id.homeSearchBar)
        searchLayout = findViewById(R.id.searchResults)
        trendingTopicLayout = findViewById(R.id.TrendingTopicsLayout)
        topMentorsLayout = findViewById(R.id.topMentorsLayout)
        trendingTxt = findViewById(R.id.trendingSearch)
        topMentorsTxt = findViewById(R.id.topMentorsSearch)
        topMentorsView = findViewById(R.id.topMentorsView)

        bottomSheetDialog = BottomSheetDialog(this,R.style.BottomSheetDialogTheme)
        bottomSheetView = LayoutInflater.from(this).inflate(R.layout.profile_bottomview, findViewById(R.id.bottomsheetContainerProfile))

        searchBar.setOnClickListener { visibleAndGone(searchLayout) }


        trendingTxt.setOnClickListener {
            trendingTxt.setTextColor(ContextCompat.getColor(this,R.color.text2))
            topMentorsTxt.setTextColor(ContextCompat.getColor(this,R.color.black))
            trendingTopicLayout.visibility = View.VISIBLE
            topMentorsLayout.visibility = View.GONE
        }
        topMentorsTxt.setOnClickListener {
            setRecyclerView()
            trendingTxt.setTextColor(ContextCompat.getColor(this,R.color.black))
            topMentorsTxt.setTextColor(ContextCompat.getColor(this,R.color.text2))
            trendingTopicLayout.visibility = View.GONE
            topMentorsLayout.visibility = View.VISIBLE
        }

    }

    private fun getData(){
        mentorsList.add(Mentor("IU","Data Scientist, Apple","110 Followers",R.drawable.profile4))
        mentorsList.add(Mentor("Mina","Android Developer, Spotify","196 Followers",R.drawable.profile5))
        mentorsList.add(Mentor("Zendya","AWS Developer, Stripe","95 Followers",R.drawable.profile6))
        mentorsList.add(Mentor("Samuel","Full-Stack Developer, Google","204 Followers",R.drawable.profile1))
        mentorsList.add(Mentor("Nancy","IOS Developer, Adobe","196 Followers",R.drawable.profile2))
        mentorsList.add(Mentor("Selena","AWS Developer, Amazon","135 Followers",R.drawable.profile3))
        topMentorsAdapter = MentorsAdapter(R.layout.listview_mentors_vert,mentorsList,this)
    }

    private fun setRecyclerView(){
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        topMentorsView.layoutManager = layoutManager
        topMentorsView.adapter = topMentorsAdapter
    }

    private fun visibleAndGone(view: View){
        if(view.visibility == View.VISIBLE) view.visibility = View.GONE
        else view.visibility =  View.VISIBLE
    }

    override fun onRecyclerViewItemClick(position : Int) {
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.findViewById<CircleImageView>(R.id.imageBottom)
            ?.setImageResource(mentorsList[position].image)
        bottomSheetDialog.findViewById<TextView>(R.id.nameBottom)?.text = mentorsList[position].name
        bottomSheetDialog.findViewById<TextView>(R.id.companyBottom)?.text = mentorsList[position].company
        bottomSheetDialog.findViewById<TextView>(R.id.followersBottom)?.text = mentorsList[position].followers
        bottomSheetDialog.show()
    }

    override fun onBackPressed() {
        if(searchLayout.isVisible){
            visibleAndGone(searchLayout)
            return
        }
        super.onBackPressed()
    }

}