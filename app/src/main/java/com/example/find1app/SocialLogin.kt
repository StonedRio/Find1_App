package com.example.find1app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.find1app.databinding.ActivitySocialLoginBinding

class SocialLogin : AppCompatActivity() {
    private lateinit var binding:ActivitySocialLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySocialLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginText.setOnClickListener {
            intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}