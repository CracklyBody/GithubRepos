package ru.tech_reliab.githubrepos.service

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.tech_reliab.githubrepos.model.UserRepository

interface GithubRepos {
    @GET("/users/{user}/repos")
    fun getRepo(@Path("user") name: String): Observable<List<UserRepository>>
}