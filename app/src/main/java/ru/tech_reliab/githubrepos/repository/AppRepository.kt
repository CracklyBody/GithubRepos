package ru.tech_reliab.githubrepos.repository

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.tech_reliab.githubrepos.model.UserRepository

class AppRepository {

    fun loadGitHubRepositories(username: String): Observable<List<UserRepository>> {
        val github = GithubRepository()
        return github.loadRepositories(username).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}