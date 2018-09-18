package com.github.gibbrich.arrowgithub.arrow_implementation

import arrow.data.*
import com.github.gibbrich.arrowgithub.model.Repository
import com.github.gibbrich.arrowgithub.view.repositories.RepositoriesView

fun getRepositories(): Reader<RepositoriesDeps, Unit> =
        ReaderApi.ask<RepositoriesDeps>()
                .flatMap { deps ->
                    repositoryUseCase()
                            .map { io ->
                                io.unsafeRunAsync { reposEither ->
                                    reposEither.fold(
                                            { deps.view.showGenericError() },
                                            { reposList -> drawRepos(reposList, deps.view) }
                                    )
                                }
                            }
                }

private fun drawRepos(
        repositoryList: List<Repository>,
        view: RepositoriesView
) {
    val repositoriesSorted = repositoryList.sortedByDescending { it.stargazersCount }
    view.drawRepositories(repositoriesSorted)
}