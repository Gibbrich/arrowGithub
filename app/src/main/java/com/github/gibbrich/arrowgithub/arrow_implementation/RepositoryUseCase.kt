package com.github.gibbrich.arrowgithub.arrow_implementation

import arrow.data.Reader
import arrow.effects.IO
import com.github.gibbrich.arrowgithub.model.Repository

fun repositoryUseCase(): Reader<RepositoriesDeps, IO<List<Repository>>> = fetchAllRepositories()