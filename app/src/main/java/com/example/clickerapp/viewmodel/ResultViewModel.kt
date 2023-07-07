package com.example.clickerapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clickerapp.common.SingleLiveDataEmpty
import com.example.clickerapp.database.UserRepository
import com.example.clickerapp.model.User
import com.example.clickerapp.view.adapter.UsersAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ResultViewModel(private val repository: UserRepository): ViewModel() {

    val backPressed = SingleLiveDataEmpty()
    val userList = MutableLiveData<List<User>>()

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val users = repository.getAll()
            withContext(Dispatchers.Main) {
                userList.value = users
            }
        }
    }



    fun onBackPress() {
        backPressed.call()
    }
}