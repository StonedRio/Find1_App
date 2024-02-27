package com.example.find1app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.find1app.R
import com.example.find1app.activities.HomeActivity
import com.example.find1app.databinding.FragmentMapviewBinding

class MapviewFragment : Fragment() {

    private var _binding: FragmentMapviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentMapviewBinding.inflate(inflater,container,false)
        val view=binding.root

        binding.arrowBack.setOnClickListener {
            (activity as? HomeActivity)?.replaceFragment(ResultsFragment())
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as? HomeActivity)?.toggleAppBarVisibility(show = true)
        (activity as? HomeActivity)?.toggleCoordinatorVisibility(show = true)
    }

    override fun onResume() {
        super.onResume()
        (activity as? HomeActivity)?.toggleAppBarVisibility(show = false)
        (activity as? HomeActivity)?.toggleCoordinatorVisibility(show = false)
    }

}