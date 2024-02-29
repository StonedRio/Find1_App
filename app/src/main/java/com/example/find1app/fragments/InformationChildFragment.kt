package com.example.find1app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.find1app.R
import com.example.find1app.databinding.FragmentInformationChildBinding

class InformationChildFragment : Fragment() {
    private var _binding: FragmentInformationChildBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentInformationChildBinding.inflate(inflater,container,false)
        val view=binding.root



        return view
    }
}