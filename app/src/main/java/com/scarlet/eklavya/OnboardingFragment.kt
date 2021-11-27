package com.scarlet.eklavya

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.scarlet.eklavya.adapters.SliderAdapter

class OnboardingFragment : Fragment() {

    private lateinit var viewPager : ViewPager
    private lateinit var dotsLayout : LinearLayout
    private lateinit var menteeBtn : Button

    private lateinit var sliderAdapter : SliderAdapter
    private lateinit var dots : Array<TextView?>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding, container, false)
        initView(view);
        return view
    }

    private fun initView(view: View){
        viewPager = view.findViewById(R.id.slider)
        dotsLayout = view.findViewById(R.id.dots)
        menteeBtn = view.findViewById(R.id.menteeBtn)

        menteeBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.fragment_container,MenteeFragment())
                ?.commit()
        }

        sliderAdapter = SliderAdapter(this.activity?.applicationContext)
        viewPager.adapter = sliderAdapter
        addDots()
    }

    private fun addDots(){

        dots = arrayOfNulls<TextView?>(3)
        for (i in dots.indices){
            dots[i] = TextView(this.activity?.applicationContext)
            dots[i]?.text = Html.fromHtml("&#8226",Html.FROM_HTML_MODE_LEGACY)
            dots[i]?.textSize = 35f
            dotsLayout.addView(dots[i])
        }
    }

}