package com.example.coctailsapplication

import android.app.Application
import com.example.coctailsapplication.di.localModule
import com.example.coctailsapplication.di.networkModule
import com.example.coctailsapplication.di.repositoryModule
import com.example.coctailsapplication.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                repositoryModule,
                viewModelsModule,
                localModule
            )
        }
    }
}