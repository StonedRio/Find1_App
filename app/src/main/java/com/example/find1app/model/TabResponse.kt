package com.example.find1app.model

data class TabResponse(
    val success: Boolean,
    val result: List<Tab>
)

data class Tab(
    val id: Int,
    val name: String
)

