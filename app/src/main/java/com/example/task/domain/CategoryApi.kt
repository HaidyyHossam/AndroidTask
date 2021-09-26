package com.example.task.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseValueCategories(
    @SerializedName("data")
    val data: dataCategories
)
class dataCategories (
    @SerializedName("categories")
    @Expose
    val categories : List<categories>
)
class categories(
    @SerializedName("name")
    @Expose
    val name:String
)