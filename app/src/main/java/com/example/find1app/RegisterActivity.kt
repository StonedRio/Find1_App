package com.example.find1app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.find1app.databinding.ActivityMainBinding


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Initialize binding
        setContentView(binding.root)

        binding.loginText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.socialLoginText.setOnClickListener {
            val intent = Intent(this, SocialLoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}