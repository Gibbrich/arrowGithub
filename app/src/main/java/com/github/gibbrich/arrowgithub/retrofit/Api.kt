package com.github.gibbrich.arrowgithub.retrofit

import com.github.gibbrich.arrowgithub.model.GithubAnswer
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("search/repositories")
    fun getRepositories(
            @Query("q") language: String,
            @Query("sort") order: String,
            @Query("page") page: Int
    ): Single<GithubAnswer>
}

fun apiClient() : ApiClient = retrofit().create(ApiClient::class.java)