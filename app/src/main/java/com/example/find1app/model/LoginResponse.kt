package com.example.find1app.model

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val user: User
)

data class User(
    val last_login: String,
    val createdAt: String,
    val updatedAt: String,
    val id: Int,
    val role_id: Int?,
    val uuid: String,
    val username: String,
    val password: String,
    val email: String,
    val name: String,
    val about: String?,
    val mobile_no: String,
    val profile_image: String,
    val profile_image_thumb: String?,
    val background_image: String?,
    val gender: String?,
    val country: String?,
    val city: String?,
    val is_approved: Int,
    val user_type: String,
    val is_notification: Boolean,
    val token: String,
    val is_active: Boolean
)


