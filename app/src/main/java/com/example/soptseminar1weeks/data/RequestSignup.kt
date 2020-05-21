package com.example.soptseminar1weeks.data

data class RequestSignup(
    val id: String,
    val password: String,
    val name: String,
    val email: String,
    val phone: String
)