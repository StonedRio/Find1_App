package com.example.find1app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.find1app.activities.HomeActivity
import com.example.find1app.databinding.FragmentBrowseChildBinding

class BrowseChildFragment : Fragment() {
    private var _binding: FragmentBrowseChildBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentBrowseChildBinding.inflate(inflater,container,false)
        val view=binding.root

        binding.informationContainer.setOnClickListener {
            val parentFragment = parentFragment
            if (parentFragment is DetailsFragment ){
                parentFragment.replaceChildFragment(InformationChildFragment())
            }
        }

        binding.sustainabilityContainer.setOnClickListener {
            val parentFragment = parentFragment
            if (parentFragment is DetailsFragment ){
                parentFragment.replaceChildFragment(SustainabilityChildFragment())
            }
        }

        binding.feeStructureContainer.setOnClickListener {
            val parentFragment = parentFragment
            if (parentFragment is DetailsFragment ){
                parentFragment.replaceChildFragment(FeeStructureChildFragment())
            }
        }

        binding.galleryContainer.setOnClickListener {
            val parentFragment = parentFragment
            if (parentFragment is DetailsFragment ){
                parentFragment.replaceChildFragment(GalleryChildFragment())
            }
        }

        binding.reviewsContainer.setOnClickListener {
            val parentFragment = parentFragment
            if (parentFragment is DetailsFragment ){
                parentFragment.replaceChildFragment(ReviewsChildFragment())
            }
        }

        binding.bookNowButton.setOnClickListener {
            (activity as? HomeActivity)?.replaceFragment(ParentBookingFragment())
        }

        return view
    }
}