package com.example.find1app.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.find1app.adapter.HorizontalListAdapter
import com.example.find1app.databinding.BottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialogFragment : BottomSheetDialogFragment() {
    private var _binding: BottomSheetLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= BottomSheetLayoutBinding.inflate(inflater,container,false)
        val view=binding.root



        val stagesList= listOf("All Grades","Elementary","Kindergarten and Nursery","High School")
        binding.stageRecyclerView.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.stageRecyclerView.adapter= HorizontalListAdapter(stagesList)

        val genderList= listOf("Boys and Girls","Boys","Girls")
        binding.genderRecyclerView.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.genderRecyclerView.adapter= HorizontalListAdapter(genderList)

        val schoolTypeList= listOf("International","National","Special Needs","Typical")
        binding.schoolTypeRecyclerView.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.schoolTypeRecyclerView.adapter= HorizontalListAdapter(schoolTypeList)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}