package com.github.gibbrich.arrowgithub.model

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("id")
        val id: Long,

        @SerializedName("avatar_url")
        val avatarUrl: String,

        @SerializedName("login")
        val login: String
)