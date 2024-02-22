package com.example.find1app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.find1app.activities.HomeActivity
import com.example.find1app.databinding.FragmentCustomSearchBinding

class CustomSearchFragment : Fragment() {

    private var _binding: FragmentCustomSearchBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnBrowseRessult.setOnClickListener {
            (activity as HomeActivity).replaceFragment(ResultsFragment())
        }

        return view
    }
}