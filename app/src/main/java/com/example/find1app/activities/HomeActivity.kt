package com.example.find1app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.find1app.R
import com.example.find1app.databinding.ActivityHomeBinding
import com.example.find1app.fragments.CustomSearchFragment
import com.example.find1app.fragments.HomeFragment
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle
    var isBlackBackground = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.backgroundTintList = getColorStateList(android.R.color.black)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Notification -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.font_size -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)

                }
                R.id.how_to -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.about_us -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

        val fragmentManager = supportFragmentManager
        val newFragment = HomeFragment()
        binding.frameLayout.replaceFragment(fragmentManager, newFragment)

        binding.drawerIcon.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }


        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    binding.frameLayout.replaceFragment(fragmentManager, newFragment)
                    true

                }
                R.id.setting -> {

                    true
                }
                R.id.notification -> {
                    true
                }
                R.id.profile -> {
                    true
                }
                else -> false
            }
        }



        binding.fab.setOnClickListener {
//            if (isBlackBackground) {
//                binding.fab.backgroundTintList = getColorStateList(R.color.primary)
                binding.frameLayout.replaceFragment(fragmentManager,CustomSearchFragment())
//            } else {
//                binding.fab.backgroundTintList = getColorStateList(android.R.color.black)
//            }
//            isBlackBackground = !isBlackBackground
        }


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun FrameLayout.replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(this.id, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }


}
