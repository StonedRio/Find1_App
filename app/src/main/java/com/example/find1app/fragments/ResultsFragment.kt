package com.example.find1app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.find1app.activities.HomeActivity
import com.example.find1app.adapter.ResultsAdapter
import com.example.find1app.databinding.FragmentResultsBinding
import com.example.find1app.model.ResultsInstitution

class ResultsFragment : Fragment() {

    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    private lateinit var resultsAdapter: ResultsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentResultsBinding.inflate(inflater,container,false)
        val view=binding.root

        binding.mapviewIcon.setOnClickListener {
            (activity as? HomeActivity)?.replaceFragment(MapviewFragment())
        }



        val results = listOf<ResultsInstitution>(
            ResultsInstitution(
                "https://example.com/image1.jpg",
                "ABC School",
                "City A",
                "Primary",
                true,
                true,
                4
            ),
            ResultsInstitution(
                "https://example.com/image2.jpg",
                "XYZ Academy",
                "City B",
                "Secondary",
                false,
                true,
                5
            ),
            ResultsInstitution(
                "https://example.com/image3.jpg",
                "123 Institute",
                "City C",
                "High School",
                true,
                false,
                3
            ),
            ResultsInstitution(
                "https://example.com/image4.jpg",
                "PQR Education Center",
                "City D",
                "Primary",
                true,
                true,
                4
            ),
            ResultsInstitution(
                "https://example.com/image5.jpg",
                "LMN School",
                "City E",
                "Secondary",
                false,
                true,
                4
            ),
            ResultsInstitution(
                "https://example.com/image6.jpg",
                "DEF Academy",
                "City F",
                "High School",
                true,
                false,
                5
            ),
            ResultsInstitution(
                "https://example.com/image7.jpg",
                "GHI Institute",
                "City G",
                "Primary",
                true,
                true,
                3
            )
        )

        resultsAdapter = ResultsAdapter(results)
        binding.resultsRecyclerview.adapter=resultsAdapter
        binding.resultsRecyclerview.layoutManager = LinearLayoutManager(this.context,
            LinearLayoutManager.VERTICAL, false)




        return view
    }
}