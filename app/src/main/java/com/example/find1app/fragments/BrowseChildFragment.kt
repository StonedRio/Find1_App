package com.example.find1app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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

        return view
    }
}