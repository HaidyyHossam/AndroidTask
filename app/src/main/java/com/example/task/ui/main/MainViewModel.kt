package com.example.task.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.task.data.repository.MainRepository
import com.example.task.domain.ResponseValueCategories
import com.example.task.domain.ResponseValueChannels
import com.example.task.domain.categories
import com.example.task.domain.channels
import kotlinx.coroutines.Dispatchers
import com.example.task.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    suspend fun getCategories(onComplete: (ArrayList<categories>) -> Unit) {
        var cats = ArrayList<categories>()

        var call = mainRepository.getCategories()
        call.enqueue(object : Callback<ResponseValueCategories> {
            override fun onResponse(call: Call<ResponseValueCategories>, response: Response<ResponseValueCategories>) {
                for (item in response.body()!!.data.categories) {
                    cats.add(item)
                }
                onComplete.invoke(cats)
            }

            override fun onFailure(call: Call<ResponseValueCategories>, t: Throwable) {
                Log.e("Error", "Failuree")
            }
        })
    }
    suspend fun getChannels(onComplete: (ArrayList<channels>) -> Unit) {
        var channels = ArrayList<channels>()

        var call = mainRepository.getChannels()
        call.enqueue(object : Callback<ResponseValueChannels> {
            override fun onResponse(call: Call<ResponseValueChannels>, response: Response<ResponseValueChannels>) {
                for (item in response.body()!!.data.channels) {
                    channels.add(item)
                }
                onComplete.invoke(channels)
            }

            override fun onFailure(call: Call<ResponseValueChannels>, t: Throwable) {
                Log.e("Error", "Failuree")
            }
        })
    }
}