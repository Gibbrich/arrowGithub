package com.github.gibbrich.arrowgithub.di.modules

import com.github.gibbrich.arrowgithub.data.GithubRepository
import com.github.gibbrich.arrowgithub.domain.RepositoryDetailUseCase
import dagger.Module
import dagger.Provides

@Module
class RepositoryDetailModule {

    @Provides
    fun provideRepositoryDetailUseCase(githubRepository: GithubRepository): RepositoryDetailUseCase {
        return RepositoryDetailUseCase(githubRepository)
    }
}