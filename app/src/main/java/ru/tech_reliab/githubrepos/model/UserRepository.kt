package ru.tech_reliab.githubrepos.model

import com.google.gson.annotations.SerializedName

class UserRepository(
    @SerializedName("name")
    var name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("language")
    val language: String
)