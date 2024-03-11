package com.example.find1app.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.find1app.databinding.ActivityLoginBinding
import com.example.find1app.model.LoginResponse
import com.example.find1app.services.ApiService
import com.example.find1app.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Response

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
            val username:String=binding.emailInputLayout.editText?.text.toString()
            val password:String=binding.passwordInputLayout.editText?.text.toString()
            loginUser(username,password)
        }

    }


    private fun loginUser(username: String, password: String) {
        val apiService = ServiceBuilder.buildService(ApiService::class.java)
        val requestCall = apiService.loginUser(username, password)

        requestCall.enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        // Handling the response
                        if (loginResponse.success) {
                            // Login successful
                            Toast.makeText(this@LoginActivity, "Logged in", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            intent.putExtra("name",loginResponse.user.name)
                            intent.putExtra("email",loginResponse.user.email)
                            intent.putExtra("token",loginResponse.user.token)
                            startActivity(intent)
                            finish()
                        } else {
                            // Login failed, handle the error message
                            val errorMessage = loginResponse.message
                             Toast.makeText(this@LoginActivity, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    // Handling other response codes
                     Toast.makeText(this@LoginActivity, "Server error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Handling network errors
                 Toast.makeText(this@LoginActivity, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }




}