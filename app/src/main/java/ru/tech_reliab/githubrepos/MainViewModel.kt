package ru.tech_reliab.githubrepos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.tech_reliab.githubrepos.model.UserRepository
import ru.tech_reliab.githubrepos.repository.AppRepository

class MainViewModel(): ViewModel() {
    val repos = MutableLiveData<List<UserRepository>>()
    
    fun loadData(username: String){
        val rep = AppRepository()
        rep.loadGitHubRepositories(username).subscribe{repos.value = it}
    }
}