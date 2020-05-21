package com.example.soptseminar1weeks.data

data class ResponseLogin(
    val status: String,
    val success:Boolean,
    val message: String,
    val data : SomeData? // data는 String 변수 포함한 객체
)

data class SomeData(
    val jwt:String
)
