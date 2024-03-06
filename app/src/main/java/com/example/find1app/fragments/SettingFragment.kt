package com.example.find1app.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.find1app.R
import com.example.find1app.activities.HomeActivity
import com.example.find1app.databinding.FragmentNotificationsBinding
import com.example.find1app.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSettingBinding.inflate(inflater,container,false)
        val view=binding.root

        sharedPreferences=requireActivity().getSharedPreferences("settings",Context.MODE_PRIVATE)
        val isDarkMode =  sharedPreferences.getBoolean("isDarkMode",false)
        binding.darkModeToggle.isChecked = isDarkMode


        binding.arrowBack.setOnClickListener {
            (activity as? HomeActivity)?.replaceFragment(HomeFragment())
        }

        binding.darkModeToggle.setOnCheckedChangeListener{ _,isChecked ->

            sharedPreferences.edit().putBoolean("isDarkMode", isChecked).apply()

            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }

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