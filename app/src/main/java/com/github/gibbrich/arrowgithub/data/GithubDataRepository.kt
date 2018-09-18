package com.github.gibbrich.arrowgithub.data

import com.github.gibbrich.arrowgithub.model.Repository
import com.github.gibbrich.arrowgithub.retrofit.ApiClient
import io.reactivex.Single
import java.lang.IllegalStateException

class GithubDataRepository(
        private val apiClient: ApiClient
) : GithubRepository {

    private var repositories: List<Repository>? = null

    override fun getRepositories(language: String, order: String, page: Int): Single<List<Repository>> {
        return repositories
                ?.let { Single.just(it) }
                ?: apiClient
                        .getRepositories(language, order, page)
                        .map { it.items }
                        .doOnSuccess { repositories = it }
    }

    override fun getRepository(id: Long): Repository {
        return repositories
                ?.first { it.id == id }
                ?: throw IllegalStateException("repositories field must be not null")
    }
}