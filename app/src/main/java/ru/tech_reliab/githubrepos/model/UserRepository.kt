package ru.tech_reliab.githubrepos.model

import com.google.gson.annotations.SerializedName

class UserRepository(
    @SerializedName("name")
    private var name: String,
    @SerializedName("description")
    private val description: String,
    @SerializedName("language")
    private val language: String
)