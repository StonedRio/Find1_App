package com.example.find1app.activities

import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.find1app.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater) // Initialize binding
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