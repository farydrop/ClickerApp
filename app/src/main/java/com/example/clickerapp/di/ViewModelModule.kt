package com.example.clickerapp.di

import com.example.clickerapp.database.UserRepository
import com.example.clickerapp.viewmodel.MainViewModel
import com.example.clickerapp.viewmodel.ResultViewModel
import com.example.clickerapp.viewmodel.ScoreRegisterViewModel
import com.example.clickerapp.viewmodel.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { StartViewModel() }
    viewModel { ScoreRegisterViewModel(get<UserRepository>()) }
    viewModel { ResultViewModel(get<UserRepository>()) }
}