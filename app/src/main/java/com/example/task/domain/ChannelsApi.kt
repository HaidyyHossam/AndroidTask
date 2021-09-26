package com.example.task.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseValueChannels(
        @SerializedName("data")
        val data: dataChannels
)
class dataChannels (
        @SerializedName("channels")
        @Expose
        val channels : List<channels>
)
class channels(
        @SerializedName("title")
        @Expose
        val title:String,
        @SerializedName("series")
        @Expose
        val series:List<series>,
        @SerializedName("mediaCount")
        @Expose
        val mediaCount:Int,
        @SerializedName("latestMedia")
        @Expose
        val latestMedia:List<courses>,
        @SerializedName("iconAsset")
        @Expose
        val iconAsset:iconAsset

)
class series(
        @SerializedName("title")
        @Expose
        val title:String,
        @SerializedName("coverAsset")
        @Expose
        val coverAsset:coverAsset
)
class courses(
        @SerializedName("type")
        @Expose
        val type:String,
        @SerializedName("title")
        @Expose
        val title:String,
        @SerializedName("coverAsset")
        @Expose
        val coverAsset:coverAsset
)
class coverAsset(
        @SerializedName("url")
        @Expose
        val url:String
)
class iconAsset(
        @SerializedName("thumbnailUrl")
        @Expose
        val thumbnailUrl:String
)