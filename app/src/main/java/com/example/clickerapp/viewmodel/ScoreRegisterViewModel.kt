
package com.example.clickerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clickerapp.database.UserRepository
import com.example.clickerapp.model.User
import kotlinx.coroutines.launch

class ScoreRegisterViewModel(private val repository: UserRepository):ViewModel() {


    fun insertUser(name: String, time: String) {
        viewModelScope.launch {
            val data = User(name, time)
            repository.insert(data)
        }
    }

}
