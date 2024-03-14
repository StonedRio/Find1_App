package com.example.find1app.services

import com.example.find1app.model.AuthResponse
import com.example.find1app.model.LoginResponse
import com.example.find1app.model.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    // Login api service
    @FormUrlEncoded
    @POST("mobile/auth/login")
    fun loginUser(
        @Field("username") email: String,
        @Field("password") password: String,
    ): Call<LoginResponse>


    // Register api service
    @FormUrlEncoded
    @POST("mobile/auth/register")
    fun registerUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("confirm_password") confirmPassword: String,
        @Field("name") name: String,
        @Field("mobile_no") mobileNumber: String,
    ): Call<RegistrationResponse>


    // Authentication api service currently commented
//    @GET("mobile/auth/me")
//    fun authUser(
//        @Query("x-access-token") accessToken: String,
//        ): Call<AuthResponse>

}