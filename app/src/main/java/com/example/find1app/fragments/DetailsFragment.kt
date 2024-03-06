package com.example.find1app.fragments

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


        replaceChildFragment(BrowseChildFragment())

        // Set initial indicator text
        val initialPage = binding.viewPager.currentItem + 1
        val totalPages = images.size
        binding.indicatorTextview.text = " $initialPage/$totalPages"

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
            val currentFragment = childFragmentManager.findFragmentById(R.id.details_frame_layout)
            if (currentFragment is BrowseChildFragment) {
                (activity as? HomeActivity)?.replaceFragment(ResultsFragment())
            } else {
                replaceChildFragment(BrowseChildFragment())
            }
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


    fun replaceChildFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.details_frame_layout, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

}