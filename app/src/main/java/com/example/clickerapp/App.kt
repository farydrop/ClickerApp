package com.example.clickerapp

import android.app.Application
import com.example.clickerapp.database.UserRepository
import com.example.clickerapp.di.daoModule
import com.example.clickerapp.di.repositoryModule
import com.example.clickerapp.di.viewModelModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    /*val applicationScope = CoroutineScope(SupervisorJob())
    val dataBase by lazy { UserDataBase.getDatabase(this,applicationScope) }
    val repository by lazy { UserRepository(dataBase.userDao()) }*/

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            // Load modules
            modules( repositoryModule, viewModelModule, daoModule )
        }
    }
}