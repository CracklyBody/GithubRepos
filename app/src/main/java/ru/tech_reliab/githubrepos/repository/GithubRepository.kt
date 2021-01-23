package ru.tech_reliab.githubrepos.repository

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.tech_reliab.githubrepos.model.UserRepository
import ru.tech_reliab.githubrepos.service.APIClient
import ru.tech_reliab.githubrepos.service.GithubRepos

class GithubRepository {
    fun loadRepositories(username: String): Observable<List<UserRepository>> {
        val apiService: GithubRepos =
            APIClient.retrofit.create(GithubRepos::class.java)


//        val repos = call.enqueue(object : Callback<List<UserRepository>> {
//            override fun onResponse(call: Call<List<UserRepository>>, response: Response<List<UserRepository>>) {
//                Log.d("COMPLETE!",response.body()!![0].name)
//            }
//
//            override fun onFailure(call: Call<List<UserRepository>>, t: Throwable) {
//                Log.d("ERROR!",t.stackTraceToString())
//            }
//        })

        return apiService.getRepo(username)
    }
}