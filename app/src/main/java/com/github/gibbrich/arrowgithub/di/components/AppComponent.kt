package com.github.gibbrich.arrowgithub.di.components

import com.github.gibbrich.arrowgithub.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent {
    fun repositoryListBuilder(): RepositoryListComponent.Builder
    fun repositoryDetailBuilder(): RepositoryDetailComponent.Builder
}