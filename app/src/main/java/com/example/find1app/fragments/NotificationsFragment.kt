package com.example.find1app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.find1app.R
import com.example.find1app.activities.HomeActivity
import com.example.find1app.databinding.FragmentNotificationsBinding
import com.example.find1app.databinding.FragmentResultsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentNotificationsBinding.inflate(inflater,container,false)
        val view=binding.root

        binding.arrowBack.setOnClickListener {
            (activity as? HomeActivity)?.replaceFragment(HomeFragment())
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as? HomeActivity)?.toggleAppBarVisibility(show = true)
    }

    override fun onResume() {
        super.onResume()
        (activity as? HomeActivity)?.toggleAppBarVisibility(show = false)
    }

}