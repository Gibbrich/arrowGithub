package com.github.gibbrich.arrowgithub.di.components

import com.github.gibbrich.arrowgithub.di.modules.RepositoryListModule
import com.github.gibbrich.arrowgithub.presenter.RepositoryListPresenter
import dagger.Subcomponent

@Subcomponent(modules = [
    RepositoryListModule::class
])
interface RepositoryListComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): RepositoryListComponent
    }

    fun inject(entry: RepositoryListPresenter)
}