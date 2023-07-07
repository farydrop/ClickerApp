package com.example.clickerapp.di

import com.example.clickerapp.database.UserRepository
import com.example.clickerapp.database.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single <UserRepository> { UserRepositoryImpl(get()) }
}