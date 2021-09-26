package com.example.task.data.repository

import com.example.task.data.api.APIHelper

class MainRepository(private val apiHelper: APIHelper) {
    suspend fun getCategories() = apiHelper.getCategories()
    suspend fun getChannels() = apiHelper.getChannels()
}