package com.github.gibbrich.arrowgithub.arrow_implementation

import com.github.gibbrich.arrowgithub.retrofit.ApiClient
import com.github.gibbrich.arrowgithub.view.repositories.RepositoriesView

data class RepositoriesDeps(
        val view: RepositoriesView,
        val apiClient: ApiClient
)