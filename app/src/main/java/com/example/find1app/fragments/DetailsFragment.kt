package com.example.find1app.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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