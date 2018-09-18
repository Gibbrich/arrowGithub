package com.github.gibbrich.arrowgithub.di.components

import com.github.gibbrich.arrowgithub.di.modules.RepositoryDetailModule
import com.github.gibbrich.arrowgithub.presenter.RepositoryDetailPresenter
import dagger.Subcomponent

@Subcomponent(modules = [
    RepositoryDetailModule::class
])
interface RepositoryDetailComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): RepositoryDetailComponent
    }

    fun inject(entry: RepositoryDetailPresenter)
}