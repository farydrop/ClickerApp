package com.example.clickerapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clickerapp.databinding.ResultItemBinding
import com.example.clickerapp.model.User

class UsersAdapter(private val usersList: ArrayList<User>) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

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

    override fun getItemCount(): Int = usersList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val users = usersList[position]
        holder.userName.text = users.name
        holder.time.text = users.time.toString()
    }

    /*fun setList(users: List<User>) {
        usersList = users
        notifyDataSetChanged()
    }*/

}