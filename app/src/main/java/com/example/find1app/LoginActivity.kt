package com.example.find1app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.find1app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.loginButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}