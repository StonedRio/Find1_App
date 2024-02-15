package com.example.find1app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.find1app.databinding.ActivityHomeBinding
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
            if (isBlackBackground) {
                binding.fab.backgroundTintList = getColorStateList(R.color.primary)
            } else {
                binding.fab.backgroundTintList = getColorStateList(android.R.color.black)
            }
            isBlackBackground = !isBlackBackground
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
