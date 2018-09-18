package com.github.gibbrich.arrowgithub.arrow_implementation

import arrow.core.Try
import arrow.data.Reader
import arrow.data.ReaderApi
import arrow.data.map
import arrow.effects.IO
import com.github.gibbrich.arrowgithub.model.Repository
import com.github.gibbrich.arrowgithub.retrofit.ApiClient
import kotlinx.coroutines.experimental.async

fun fetchAllRepositories(): Reader<RepositoriesDeps, IO<List<Repository>>> =
        ReaderApi.ask<RepositoriesDeps>()
                .map { deps ->
                    IO.async<List<Repository>> { either ->
                        async {
                            either(queryForRepositories(deps.apiClient).toEither())
                        }
                    }
                }

private fun queryForRepositories(apiClient: ApiClient): Try<List<Repository>> {
    val tr = Try {
//        apiClient
//                .getRepositories("Java", "star", 1)
//                .execute()
//                .body()!!
//                .items
    }

    TODO()
}