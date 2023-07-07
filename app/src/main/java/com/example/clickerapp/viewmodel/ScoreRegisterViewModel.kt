/*
package com.example.clickerapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.clickerapp.database.User
import com.example.clickerapp.database.UserRepository
import kotlinx.coroutines.launch

class ScoreRegisterViewModel(private val repository: UserRepository):ViewModel() {

    val allUsers: LiveData<Array<User>> = repository.allUsers.asLiveData()

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

}

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreRegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ScoreRegisterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/
