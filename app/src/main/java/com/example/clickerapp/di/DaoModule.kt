package com.example.clickerapp.di

import android.app.Application
import androidx.room.Room
import com.example.clickerapp.database.AppDatabase
import com.example.clickerapp.database.UserDao
import org.koin.dsl.module

val daoModule = module {
    single { createDataBase(get()) }
    single { createUserDao(get()) }
}

private fun createDataBase(app: Application): AppDatabase =
    Room
        .databaseBuilder(app, AppDatabase::class.java, "AppDatabase")
        .build()

private fun createUserDao(database: AppDatabase): UserDao =
    database.userDao()