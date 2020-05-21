package com.example.soptseminar1weeks.network

import com.example.soptseminar1weeks.data.ResponseLogin
import com.example.soptseminar1weeks.data.ResponseSignup
import com.example.soptseminar1weeks.data.RequestLogin
import com.example.soptseminar1weeks.data.RequestSignup
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface{
    @POST("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>

    @POST("/user/signup")
    fun requestSignup(@Body body: RequestSignup) :Call<ResponseSignup>
}