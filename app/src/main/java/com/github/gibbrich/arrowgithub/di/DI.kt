package com.github.gibbrich.arrowgithub.di

import com.github.gibbrich.arrowgithub.di.components.DaggerAppComponent
import com.github.gibbrich.arrowgithub.di.components.RepositoryDetailComponent
import com.github.gibbrich.arrowgithub.di.components.RepositoryListComponent

object DI {
    private val appComponent by lazy { DaggerAppComponent.builder().build() }

    fun repositoryListComponent(): RepositoryListComponent = appComponent.repositoryListBuilder().build()

    fun repositoryDetailComponent(): RepositoryDetailComponent = appComponent.repositoryDetailBuilder().build()
}