package com.example.find1app.services

import com.example.find1app.model.LoginResponse
import com.example.find1app.model.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    
    // Login api service
    @FormUrlEncoded
    @POST("mobile/auth/login")
    fun loginUser(
        @Field("username") email: String,
        @Field("password") password: String,
    ): Call<LoginResponse>


    // register api service
    @FormUrlEncoded
    @POST("mobile/auth/register")
    fun registerUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirm_password") confirmPassword: String,
        @Field("name") name: String,
        @Field("mobile_no") mobileNumber: String,
    ): Call<RegistrationResponse>
}