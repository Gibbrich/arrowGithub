package com.github.gibbrich.arrowgithub.di.modules

import com.github.gibbrich.arrowgithub.data.GithubDataRepository
import com.github.gibbrich.arrowgithub.data.GithubRepository
import com.github.gibbrich.arrowgithub.di.components.RepositoryDetailComponent
import com.github.gibbrich.arrowgithub.di.components.RepositoryListComponent
import com.github.gibbrich.arrowgithub.retrofit.ApiClient
import com.github.gibbrich.arrowgithub.retrofit.apiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    RepositoryListComponent::class,
    RepositoryDetailComponent::class
])
class AppModule {

    @Provides
    @Singleton
    fun provideGithubRepository(apiClient: ApiClient): GithubRepository {
        return GithubDataRepository(apiClient)
    }

    @Provides
    @Singleton
    fun provideApiClient(): ApiClient {
        return apiClient()
    }
}