package com.example.find1app.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.find1app.R
import com.example.find1app.activities.HomeActivity
import com.example.find1app.adapter.ImageSliderPagerAdapter
import com.example.find1app.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDetailsBinding.inflate(inflater,container,false)
        val view=binding.root

        (activity as HomeActivity)?.hideAppbarBackground()


        val images= listOf(R.drawable.dummy_picture,R.drawable.dummy_picture,R.drawable.dummy_picture,R.drawable.dummy_picture)
        val adapter= ImageSliderPagerAdapter(images)
        binding.viewPager.adapter=adapter
        binding.circleIndicator.setViewPager(binding.viewPager)

        // Set initial indicator text
        val initialPage = binding.viewPager.currentItem + 1
        val totalPages = images.size
        binding.indicatorTextview.text = " $initialPage/$totalPages "

        // onPageChangeListener to update indicator text
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                val currentPage = position + 1
                val totalPages = images.size
                binding.indicatorTextview.text = " $currentPage/$totalPages "
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        binding.detailsArrowBack.setOnClickListener {
            (activity as? HomeActivity)?.replaceFragment(ResultsFragment())
        }



        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        (activity as? HomeActivity)?.toggleAppBarVisibility(show = true)
        (activity as? HomeActivity)?.showAppbarBackground()

    }

    override fun onResume() {
        super.onResume()
        (activity as? HomeActivity)?.toggleAppBarVisibility(show = false)
    }
}