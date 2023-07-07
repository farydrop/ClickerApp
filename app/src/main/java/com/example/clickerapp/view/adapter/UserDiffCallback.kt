package com.example.clickerapp.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.clickerapp.database.User

class UserDiffCallback: DiffUtil.ItemCallback<User>( ) {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.user_name == newItem.user_name
    }
}
