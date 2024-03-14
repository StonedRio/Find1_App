package com.example.find1app.activities

import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.find1app.databinding.ActivityRegisterBinding
import com.example.find1app.model.RegistrationResponse
import com.example.find1app.services.ApiService
import com.example.find1app.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater) // Initialize binding
        setContentView(binding.root)

        binding.getStartedBtn.setOnClickListener {

            val email:String=binding.emailInputLayout.editText?.text.toString()
            val password:String=binding.passwordInputLayout.editText?.text.toString()
            val confirmPassword:String=binding.confirmPasswordInputLayout.editText?.text.toString()
            val name:String=binding.nameInputLayout.editText?.text.toString()
            val mobileNumber:String=binding.numberInputLayout.editText?.text.toString()

            registerUser(email,password,confirmPassword,name,mobileNumber)

        }

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

    private fun registerUser(email: String, password: String, confirmPassword: String, name: String, mobileNumber: String) {
        val apiService = ServiceBuilder.buildService(ApiService::class.java)
        val requestCall = apiService.registerUser(email,password, confirmPassword, name, mobileNumber)

        requestCall.enqueue(object: retrofit2.Callback<RegistrationResponse>{

            override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>){
                if(response.isSuccessful){
                    val loginResponse=response.body()
                    if(loginResponse != null){
                        // Handling the response
                        if(loginResponse.success){
                                //Registration successfull
                                val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
                                Toast.makeText(this@RegisterActivity,""+loginResponse.message.toString(),Toast.LENGTH_SHORT)
                        }else{
                            val errorMessage=loginResponse.message
                            Toast.makeText(this@RegisterActivity,""+loginResponse.message.toString(),Toast.LENGTH_SHORT)
                        }
                    }
                }else{
                    // Handling other response codes
                    Toast.makeText(this@RegisterActivity, "Server error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }

            }


            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                // Handling network errors
                Toast.makeText(this@RegisterActivity, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }


}