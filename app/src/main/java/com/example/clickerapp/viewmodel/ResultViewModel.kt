package com.example.clickerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.clickerapp.common.SingleLiveDataEmpty
import com.example.clickerapp.database.User
import com.example.clickerapp.database.UserRepository
import kotlinx.coroutines.launch

class ResultViewModel(): ViewModel() {

    val backPressed = SingleLiveDataEmpty()
    //val allUsers: LiveData<Array<User>> = repository.allUsers.asLiveData()

    /*fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }*/



    fun onBackPress() {
        backPressed.call()
    }
}