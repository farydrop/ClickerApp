package com.example.clickerapp.database

import androidx.annotation.MainThread
import com.example.clickerapp.model.User

interface UserRepository {

    @MainThread
    suspend fun insert(user: User)
    fun getAll(): List<User>
}
