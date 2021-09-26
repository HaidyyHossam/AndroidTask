package com.example.task.data.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.task.utils.Constants.BASE_URL


object  RetrofitBuilder {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}