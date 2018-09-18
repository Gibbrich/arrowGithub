package com.github.gibbrich.arrowgithub.model

import com.google.gson.annotations.SerializedName

data class GithubAnswer(
        @SerializedName("total_count")
        val totalCount: Long,

        @SerializedName("incomplete_results")
        val isIncomplete: Boolean,

        @SerializedName("items")
        val items: List<Repository>
)