package com.example.clickerapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clickerapp.database.User
import com.example.clickerapp.databinding.ResultItemBinding
import java.util.ArrayList

class UsersAdapter(private val userList: List<User>) : ListAdapter<User, UsersAdapter.UserViewHolder>(UserDiffCallback()) {

    //private var usersList = emptyList<User>()

    class UserViewHolder(private val binding: ResultItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val userName = binding.tvName
        val time = binding.tvTimer

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ResultItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val users = getItem(position)
        holder.userName.text = users.user_name
        holder.time.text = users.time.toString()
    }

    /*fun setList(users: List<User>) {
        usersList = users
        notifyDataSetChanged()
    }*/

}