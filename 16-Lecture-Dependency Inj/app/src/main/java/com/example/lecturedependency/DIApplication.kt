package com.example.lecturedependency

import android.app.Application
import com.example.lecturedependency.di.networkModule
import com.example.lecturedependency.di.repositoryModule
import com.example.lecturedependency.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class DIApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DIApplication)
            modules(networkModule, repositoryModule, viewModelsModule)
        }
    }
}