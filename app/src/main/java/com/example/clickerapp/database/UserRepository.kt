package com.example.clickerapp.database

import androidx.annotation.MainThread
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    //val allUsers: Flow<Array<User>> = userDao.getAll()

    @MainThread
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}