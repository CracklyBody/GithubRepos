package ru.tech_reliab.githubrepos.repository

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.tech_reliab.githubrepos.model.UserRepository
import ru.tech_reliab.githubrepos.service.APIClient
import ru.tech_reliab.githubrepos.service.GithubRepos

class GithubRepository {
    fun loadRepositories(username: String): List<UserRepository> {
        val apiService: GithubRepos =
            APIClient.retrofit.create(GithubRepos::class.java)

        val call: Call<List<UserRepository>> = apiService.getRepo(username)
        return call.execute().body() ?: listOf()
    }
}