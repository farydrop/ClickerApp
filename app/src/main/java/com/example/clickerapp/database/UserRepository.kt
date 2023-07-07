package com.example.clickerapp.database

import androidx.annotation.MainThread
import com.example.clickerapp.model.User

interface UserRepository {

    @MainThread
    suspend fun insert(user: User)
    fun getAll(): List<User>
}


/*
class UserRepository(private val userDao: UserDao) {

    //val allUsers: Flow<Array<User>> = userDao.getAll()

    @MainThread
    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    @MainThread
    suspend fun getAll(): List<User> {
        return userDao.getAll()
    }
}*/
