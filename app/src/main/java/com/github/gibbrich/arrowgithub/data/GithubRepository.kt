package com.github.gibbrich.arrowgithub.data

import com.github.gibbrich.arrowgithub.model.Repository
import io.reactivex.Single

interface GithubRepository {
    fun getRepositories(
            language: String,
            order: String,
            page: Int
    ): Single<List<Repository>>

    fun getRepository(id: Long): Repository
}