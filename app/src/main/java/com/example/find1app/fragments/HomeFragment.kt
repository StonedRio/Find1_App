package com.example.find1app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.find1app.adapter.BrowseByCitiesAdapter
import com.example.find1app.adapter.FeaturedInstitutionAdapter
import com.example.find1app.adapter.SustainableInstitutesAdapter
import com.example.find1app.databinding.FragmentHomeBinding
import com.example.find1app.model.FeaturedInstitution
import com.example.find1app.model.SustainableInstitute
import com.example.find1app.model.city
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: FeaturedInstitutionAdapter
    private lateinit var sustainableinstitutesAdapter: SustainableInstitutesAdapter
    private lateinit var cityAdapter: BrowseByCitiesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("School"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("College"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("University"))
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> Log.d("asd", "onTabSelected: ")
                    1 -> Log.d("asd", "onTabSelected: ")
                    2 -> Log.d("asd", "onTabSelected: ")
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })



        // FEATURED INSTITUTIONS RECYCLERVIEW
        val featuredInstitutions = listOf(
            FeaturedInstitution(
                imageUrl = "https://example.com/image1.jpg",
                institutionName = "Institution 1",
                rating = 4,
                startingFee = "$1000"
            ),
            FeaturedInstitution(
                imageUrl = "https://example.com/image2.jpg",
                institutionName = "Institution 2",
                rating = 5,
                startingFee = "$1500"
            ),
            FeaturedInstitution(
                imageUrl = "https://example.com/image3.jpg",
                institutionName = "Institution 3",
                rating = 3,
                startingFee = "$800"
            ),
        )
        adapter= FeaturedInstitutionAdapter(featuredInstitutions)

        binding.featuredInstitutionsRecyclerview.adapter=adapter
        binding.featuredInstitutionsRecyclerview.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL, false)




        // BROWSE BY CITIES RECYCLERVIEW
        val cities = listOf(
            city(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "fajirah",
            ),
            city(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "Ras al khyma",
            ),
            city(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "tabuk",
            ),
            city(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "dubai",
            ),
            city(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "sharjah",
            ),
        )

        cityAdapter= BrowseByCitiesAdapter(cities)

        binding.browseByCitiesRecyclerview.adapter=cityAdapter
        binding.browseByCitiesRecyclerview.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL, false)



        // SUSTAINABLE INSTITUTES RECYCLERVIEW
        val SustainableInstitutes = listOf(
            SustainableInstitute(
                imageUrl = "https://example.com/image3.jpg",
                institutionName = "Institution 1",
                rating = 3,
                progress = "75%"
            ),
            SustainableInstitute(
                imageUrl = "https://example.com/image3.jpg",
                institutionName = "Institution 2",
                rating = 3,
                progress = "75%"
            ),
            SustainableInstitute(
                imageUrl = "https://example.com/image3.jpg",
                institutionName = "Institution 3",
                rating = 3,
                progress = "75%"
            ),
            SustainableInstitute(
                imageUrl = "https://example.com/image3.jpg",
                institutionName = "Institution 4",
                rating = 3,
                progress = "75%"
            ),
        )

        sustainableinstitutesAdapter= SustainableInstitutesAdapter(SustainableInstitutes)

        binding.sustainableInstitutesRecyclerview.adapter=sustainableinstitutesAdapter
        binding.sustainableInstitutesRecyclerview.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL, false)




        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
