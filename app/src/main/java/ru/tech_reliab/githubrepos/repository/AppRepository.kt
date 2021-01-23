package ru.tech_reliab.githubrepos.repository

import ru.tech_reliab.githubrepos.model.UserRepository

class AppRepository {

    fun loadGitHubRepositories(username: String): List<UserRepository> {
        val github = GithubRepository()
        return github.loadRepositories(username)
    }
}