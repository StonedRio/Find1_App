package com.example.find1app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.find1app.R
import com.example.find1app.activities.HomeActivity
import com.example.find1app.databinding.FragmentPersonalInfoBinding

class PersonalInfoFragment : Fragment() {
    private var _binding: FragmentPersonalInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentPersonalInfoBinding.inflate(inflater,container,false)
        val view=binding.root

        binding.arrowBack.setOnClickListener {
            (activity as? HomeActivity)?.replaceFragment(ProfileFragment())
        }


        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as? HomeActivity)?.toggleAppBarVisibility(show = false)
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as? HomeActivity)?.toggleAppBarVisibility(show = true)
    }

}