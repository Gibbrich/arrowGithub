package com.github.gibbrich.arrowgithub.domain

import com.github.gibbrich.arrowgithub.data.GithubRepository
import com.github.gibbrich.arrowgithub.model.Repository
import io.reactivex.Single

class RepositoryListUseCase(
        private val repository: GithubRepository
) {

    fun getRepositories(
            language: String,
            order: String,
            page: Int
    ): Single<List<Repository>> = repository.getRepositories(language, order, page)
}