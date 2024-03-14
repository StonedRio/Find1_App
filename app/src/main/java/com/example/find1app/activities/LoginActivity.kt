package com.example.find1app.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.find1app.databinding.ActivityLoginBinding
import com.example.find1app.model.AuthResponse
import com.example.find1app.model.LoginResponse
import com.example.find1app.services.ApiService
import com.example.find1app.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // getting token from shared preferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val accessToken: String? = sharedPreferences.getString("token",null)
        if(accessToken != null){

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("token",accessToken)
            startActivity(intent)
            finish()
//            authenticateUser(accessToken)

        }



        // create account text click listener code
        binding.createAccount.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        // login button click listener code
        binding.loginButton.setOnClickListener {
            val username:String=binding.emailInputLayout.editText?.text.toString()
            val password:String=binding.passwordInputLayout.editText?.text.toString()
            loginUser(username,password)
        }

    }




      // the implementation code of authenticate user currently commented due to no need of it
//    private fun authenticateUser(accessToken: String){
//        val apiService = ServiceBuilder.buildService(ApiService::class.java)
//        val requestCall = apiService.authUser(accessToken)
//
//        requestCall.enqueue(object : retrofit2.Callback<AuthResponse>{
//            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
//                if(response.isSuccessful){
//                    val authResponse = response.body()
//                    if (authResponse != null){
//                        if (authResponse.success){
//                            // Authentication successful
//                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
//                            startActivity(intent)
//                            finish()
//                        } else {
//                            // Authentication failed
//                            Toast.makeText(this@LoginActivity, "Authentication Failed", Toast.LENGTH_SHORT).show()
//                        }
//                    } else {
//                        // Response body is null
//                        Toast.makeText(this@LoginActivity, "Response body is null", Toast.LENGTH_SHORT).show()
//                    }
//                } else {
//                    // Error response codes
//                    Toast.makeText(this@LoginActivity, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//
//            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//                // Network error
//                Toast.makeText(this@LoginActivity,"Network Error",Toast.LENGTH_SHORT).show()
//            }
//        })
//    }



    // method for saving token to shared preferences
    private fun saveToken(token: String){
        val editor = sharedPreferences.edit()
        editor.putString("token",token)
        editor.apply()
    }



    // login method used in login button click listener
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
                            Toast.makeText(this@LoginActivity, loginResponse.message, Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            intent.putExtra("last_login", loginResponse.user.last_login)
                            intent.putExtra("createdAt", loginResponse.user.createdAt)
                            intent.putExtra("updatedAt", loginResponse.user.updatedAt)
                            intent.putExtra("id", loginResponse.user.id)
                            intent.putExtra("role_id", loginResponse.user.role_id)
                            intent.putExtra("uuid", loginResponse.user.uuid)
                            intent.putExtra("username", loginResponse.user.username)
                            intent.putExtra("password", loginResponse.user.password)
                            intent.putExtra("email", loginResponse.user.email)
                            intent.putExtra("name", loginResponse.user.name)
                            intent.putExtra("about", loginResponse.user.about)
                            intent.putExtra("mobile_no", loginResponse.user.mobile_no)
                            intent.putExtra("profile_image", loginResponse.user.profile_image)
                            intent.putExtra("profile_image_thumb", loginResponse.user.profile_image_thumb)
                            intent.putExtra("background_image", loginResponse.user.background_image)
                            intent.putExtra("gender", loginResponse.user.gender)
                            intent.putExtra("country", loginResponse.user.country)
                            intent.putExtra("city", loginResponse.user.city)
                            intent.putExtra("is_approved", loginResponse.user.is_approved)
                            intent.putExtra("user_type", loginResponse.user.user_type)
                            intent.putExtra("is_notification", loginResponse.user.is_notification)
                            intent.putExtra("token", loginResponse.user.token)
                            intent.putExtra("is_active", loginResponse.user.is_active)

                            if(binding.keepLoggedinCheckbox.isChecked){
                                saveToken(loginResponse.user.token)
                            }
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


