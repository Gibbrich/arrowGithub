package com.github.gibbrich.arrowgithub.presenter

import com.github.gibbrich.arrowgithub.di.DI
import com.github.gibbrich.arrowgithub.domain.RepositoryDetailUseCase
import com.github.gibbrich.arrowgithub.view.repository.RepositoryDetailView
import javax.inject.Inject

class RepositoryDetailPresenter(
        private val view: RepositoryDetailView,
        private val repositoryId: Long
) {

    @Inject
    internal lateinit var repositoryDetailUseCase: RepositoryDetailUseCase

    init {
        DI.repositoryDetailComponent().inject(this)
    }

    fun initView() {
        val repository = repositoryDetailUseCase.getRepository(repositoryId)
        view.drawRepository(
                repository.name,
                repository.owner.login,
                repository.description
        )
    }
}