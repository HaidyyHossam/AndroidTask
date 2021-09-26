package com.example.task.data.api

import com.example.task.domain.ResponseValueCategories
import com.example.task.domain.ResponseValueChannels
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("A0CgArX3")
    fun getCategories(): Call<ResponseValueCategories>
    @GET("Xt12uVhM")
    fun getChannels(): Call<ResponseValueChannels>
}