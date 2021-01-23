package ru.tech_reliab.githubrepos.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.tech_reliab.githubrepos.model.UserRepository

interface GithubRepos {
    @GET("/users/{user}/repos")
    fun getRepo(@Path("user") name: String): Call<List<UserRepository>>
}