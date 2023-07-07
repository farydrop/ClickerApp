package com.example.clickerapp.database

import com.example.clickerapp.model.User

class UserRepositoryImpl(private val userDao: UserDao):UserRepository {
    override suspend fun insert(user: User) {
        userDao.insert(user)
    }

    override fun getAll(): List<User> = userDao.getAll()
}