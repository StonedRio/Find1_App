package com.example.find1app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.find1app.R
import androidx.viewpager.widget.PagerAdapter

class ImageSliderPagerAdapter(private val images: List<Int>) : PagerAdapter() {

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.slider_image_cardview, container, false)
        val imageView = view.findViewById<ImageView>(R.id.image_view)
        imageView.setImageResource(images[position])
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
