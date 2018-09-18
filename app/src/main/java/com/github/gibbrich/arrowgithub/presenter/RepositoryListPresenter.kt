package com.github.gibbrich.arrowgithub.presenter

import com.github.gibbrich.arrowgithub.di.DI
import com.github.gibbrich.arrowgithub.domain.RepositoryListUseCase
import com.github.gibbrich.arrowgithub.view.repositories.RepositoriesView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryListPresenter(
        private val view: RepositoriesView
) {
    @Inject
    internal lateinit var repositoryListUseCase: RepositoryListUseCase

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        DI.repositoryListComponent().inject(this)
    }

    fun getRepositories() {
        compositeDisposable.add(
                repositoryListUseCase
                        .getRepositories("Java", "start", 1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(view::drawRepositories, { view.showGenericError() })
        )
    }

    fun onRepositoryListItemClick(repositoryId: Long) = view.switchToRepositoryDetailScreen(repositoryId)
}
