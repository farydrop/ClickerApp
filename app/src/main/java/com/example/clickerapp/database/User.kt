package com.example.clickerapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "user_name")val user_name: String,
    @ColumnInfo(name = "time") val time: String,
) {
    constructor(user_name: String, time: String) : this(0, user_name, time)
}