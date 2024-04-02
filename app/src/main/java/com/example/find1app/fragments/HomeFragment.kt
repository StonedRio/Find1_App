package com.example.find1app.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.find1app.activities.HomeActivity
import com.example.find1app.adapter.BrowseByCitiesAdapter
import com.example.find1app.adapter.FeaturedInstitutionAdapter
import com.example.find1app.adapter.SustainableInstitutesAdapter
import com.example.find1app.databinding.FragmentHomeBinding
import com.example.find1app.model.City
import com.example.find1app.model.FeaturedInstitution
import com.example.find1app.model.SustainableInstitute
import com.example.find1app.model.Tab
import com.example.find1app.model.TabResponse
import com.example.find1app.services.ApiService
import com.example.find1app.services.ServiceBuilder
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    val selectedTab=binding.tabLayout.selectedTabPosition
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

        // here i"m calling method of fetching tab layout data
        fetchTabData()




        // filter icon click listener
        binding.filterIcon.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialogFragment()
            bottomSheetDialog.show(childFragmentManager, "BottomSheetDialogFragment")
        }



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
        adapter.onItemClick={
            (activity as? HomeActivity)?.replaceFragment(DetailsFragment())
        }
        binding.featuredInstitutionsRecyclerview.adapter=adapter
        binding.featuredInstitutionsRecyclerview.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL, false)




        // BROWSE BY CITIES RECYCLERVIEW
        val cities = listOf(
            City(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "fajirah",
            ),
            City(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "Ras al khyma",
            ),
            City(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "tabuk",
            ),
            City(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "dubai",
            ),
            City(
                imageUrl = "https://example.com/image1.jpg",
                cityName = "sharjah",
            ),
        )

        cityAdapter= BrowseByCitiesAdapter(cities)
        cityAdapter.onItemClick={
            (activity as? HomeActivity)?.replaceFragment(ResultsFragment())
        }
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
        sustainableinstitutesAdapter.onItemClick={
            (activity as? HomeActivity)?.replaceFragment(DetailsFragment())
        }
        binding.sustainableInstitutesRecyclerview.adapter=sustainableinstitutesAdapter
        binding.sustainableInstitutesRecyclerview.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.HORIZONTAL, false)

        return view
    }









    // METHOD FOR FETCHING TABLAYOUT DATA AND GETTING CURRENT TAB
    private fun fetchTabData() {
        val service = ServiceBuilder.buildService(ApiService::class.java)
        val call = service.getTabs()

        call.enqueue(object : Callback<TabResponse> {
            override fun onResponse(call: Call<TabResponse>, response: Response<TabResponse>) {
                if (response.isSuccessful) {
                    val tabResponse = response.body()
                    tabResponse?.let {
                        setupTabs(it.result)
                    }
                } else {
                    Log.d("HomeFragment", "error "+response.message())
                }
            }

            override fun onFailure(call: Call<TabResponse>, t: Throwable) {
                Log.d("HomeFragment", "Network Error ")
            }
        })
    }


//  METHOD FOR SETTING UP TAB
    private fun setupTabs(tabs: List<Tab>) {
        for (tab in tabs) {
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(tab.name))
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val currentTabPosition = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
