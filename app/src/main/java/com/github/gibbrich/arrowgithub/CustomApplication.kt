package com.github.gibbrich.arrowgithub

import android.app.Application
import com.github.gibbrich.arrowgithub.di.components.DaggerAppComponent
import com.github.gibbrich.arrowgithub.retrofit.initRetrofit

class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initRetrofit(this)
    }
}