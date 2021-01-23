package ru.tech_reliab.githubrepos

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import ru.tech_reliab.githubrepos.model.UserRepository
import ru.tech_reliab.githubrepos.repository.AppRepository
import ru.tech_reliab.githubrepos.repository.GithubRepository
import ru.tech_reliab.githubrepos.service.APIClient

class RepositoryTest: Assert() {

    @Test
    fun createRetrofit() = assertNotNull(APIClient.retrofit)

    @Test
    fun getUserRepositoriesTest() {
        val githubServiceImpl = GithubRepository()
        val observer = TestObserver<List<UserRepository>>()

        val userRepositories: Observable<List<UserRepository>> =
            githubServiceImpl.loadRepositories("CracklyBody")
        userRepositories.subscribe(observer)

        observer.assertComplete()
        observer.assertNoErrors()
        observer.assertValueCount(1)
    }
    @Test
    fun getAnotherUserRepositoriesTest() {
        val githubServiceImpl = GithubRepository()
        val observer = TestObserver<List<UserRepository>>()

        val userRepositories: Observable<List<UserRepository>> =
            githubServiceImpl.loadRepositories("Djerys")
        userRepositories.subscribe(observer)

        observer.assertComplete()
        observer.assertNoErrors()
        observer.assertValueCount(1)
        assertEquals(observer.values()[0].size,13)
    }
}