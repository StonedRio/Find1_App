package com.example.find1app.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.find1app.R
import com.example.find1app.databinding.ActivityHomeBinding
import com.example.find1app.fragments.CustomSearchFragment
import com.example.find1app.fragments.HomeFragment
import com.example.find1app.fragments.NotificationsFragment
import com.example.find1app.fragments.ProfileFragment
import com.example.find1app.fragments.SettingFragment
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {


    private lateinit var binding:ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle
    var isBlackBackground = false

    private var originalStatusBarColor = 0
    private var originalSystemUiVisibility = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            originalStatusBarColor = getWindow().getStatusBarColor();
        }
        originalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();



        binding.fab.backgroundTintList = getColorStateList(android.R.color.black)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // Logout click
        binding.logoutLayout.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove("token")
            editor.apply()

            val intent= Intent(this@HomeActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


        // menu used in drawer layout
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Notification -> {
                    replaceFragment(NotificationsFragment())
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

        replaceFragment(HomeFragment())

        // hamburger icon click listener code for opening and closing drawer layout
        binding.drawerIcon.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }


        // code of bottom menu for each of item click
        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true

                }
                R.id.setting -> {
                    replaceFragment(SettingFragment())
                    true
                }
                R.id.notification -> {
                    replaceFragment(NotificationsFragment())
                    true
                }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }


        //code for custom search button click listener used on the top of bottom menu
        binding.fab.setOnClickListener {
//            if (isBlackBackground) {
//                binding.fab.backgroundTintList = getColorStateList(R.color.primary)
                replaceFragment(CustomSearchFragment())
//            } else {
//                binding.fab.backgroundTintList = getColorStateList(android.R.color.black)
//            }
//            isBlackBackground = !isBlackBackground
        }


    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }



    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }



    fun toggleAppBarVisibility(show: Boolean) {
        binding.appBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    fun toggleCoordinatorVisibility(show: Boolean) {
        binding.coordinatorLayout.visibility = if (show) View.VISIBLE else View.GONE
    }



    fun hideAppbarBackground(){
        window.statusBarColor = Color.TRANSPARENT
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
    }

    fun showAppbarBackground(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(originalStatusBarColor);
        }
        getWindow().getDecorView().setSystemUiVisibility(originalSystemUiVisibility);
    }



}
