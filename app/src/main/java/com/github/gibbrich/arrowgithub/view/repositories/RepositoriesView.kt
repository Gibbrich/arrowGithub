package com.github.gibbrich.arrowgithub.view.repositories

import com.github.gibbrich.arrowgithub.model.Repository

interface RepositoriesView {
    fun showNotFoundError()
    fun showGenericError()
    fun showAuthenticationError()
    fun drawRepositories(repositories: List<Repository>)
    fun switchToRepositoryDetailScreen(repositoryId: Long)
}