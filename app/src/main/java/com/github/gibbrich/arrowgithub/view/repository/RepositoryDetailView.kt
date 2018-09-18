package com.github.gibbrich.arrowgithub.view.repository

interface RepositoryDetailView {
    fun drawRepository(
            repositoryName: String,
            repositoryDescription: String,
            ownerName: String
    )
}