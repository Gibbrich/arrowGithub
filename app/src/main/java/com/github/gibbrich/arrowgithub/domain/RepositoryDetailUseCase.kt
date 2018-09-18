package com.github.gibbrich.arrowgithub.domain

import com.github.gibbrich.arrowgithub.data.GithubRepository
import com.github.gibbrich.arrowgithub.model.Repository

class RepositoryDetailUseCase(
        private val repository: GithubRepository
) {
    fun getRepository(id: Long): Repository = repository.getRepository(id)
}