package com.example.find1app.model

data class AuthResponse(
    val success: Boolean,
    val user: AuthUser
)

data class AuthUser(
    val last_login: String,
    val id: Int,
    val uuid: String,
    val username: String,
    val email: String,
    val name: String?,  // can be null
    val about: String?,  // can be null
    val mobile_no: String,
    val profile_image: String,
    val profile_image_thumb: String?,  // can be null
    val background_image: String?,  // can be null
    val gender: String?,  // can be null
    val country: String?,  // can be null
    val city: String?,  // can be null
    val is_approved: Int,
    val user_type: String,
    val register_from: String,
    val is_notification: Boolean,
    val token: String,
    val is_active: Int
)