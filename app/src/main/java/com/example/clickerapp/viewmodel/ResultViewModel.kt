package com.example.clickerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clickerapp.database.UserRepository
import com.example.clickerapp.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ResultViewModel(private val repository: UserRepository): ViewModel() {

    val userList = MutableLiveData<List<User>>()

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val users = repository.getAll()
                withContext(Dispatchers.Main) {
                    userList.value = users
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    userList.value = emptyList()
                }
            }
        }
    }
}