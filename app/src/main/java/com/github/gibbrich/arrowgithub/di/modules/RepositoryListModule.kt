package com.github.gibbrich.arrowgithub.di.modules

import com.github.gibbrich.arrowgithub.data.GithubRepository
import com.github.gibbrich.arrowgithub.domain.RepositoryListUseCase
import dagger.Module
import dagger.Provides

@Module
class RepositoryListModule {

    @Provides
    fun provideRepositoryListUseCase(githubRepository: GithubRepository): RepositoryListUseCase {
        return RepositoryListUseCase(githubRepository)
    }
}