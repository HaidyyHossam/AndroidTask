package com.example.task.data.api

class APIHelper(private val apis: ApiService) {
    suspend fun getCategories() = apis.getCategories()
    suspend fun getChannels() = apis.getChannels()
}