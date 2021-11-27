package com.scarlet.eklavya.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.scarlet.eklavya.R

class SliderAdapter(private var context: Context?) : PagerAdapter() {

    private val images = arrayOf(R.drawable.ic_intro1,R.drawable.ic_intro2,R.drawable.ic_intro3)
    private val headings = arrayOf(R.string.first_slide_title,R.string.second_slide_title,R.string.third_slide_title)
    private val descs = arrayOf(R.string.first_slide_desc,R.string.second_slide_desc,R.string.third_slide_desc)

    override fun getCount(): Int = headings.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view == `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.slides_layout,container,false)

        val image = view.findViewById<ImageView>(R.id.sliderImage)
        val titleText = view.findViewById<TextView>(R.id.sliderTitleText)
        val mainText = view.findViewById<TextView>(R.id.sliderMainText)

        image.setImageResource(images[position])
        titleText.setText(headings[position])
        mainText.setText(descs[position])

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}