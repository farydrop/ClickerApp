package com.example.clickerapp.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickerapp.databinding.ActivityResultBinding
import com.example.clickerapp.view.adapter.UsersAdapter
import com.example.clickerapp.viewmodel.ResultViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private val viewModel: ResultViewModel by viewModel()
    private var usersAdapter: UsersAdapter? = null


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }

        viewModel.getUsers()
        viewModel.userList.observe(this) {
            usersAdapter = UsersAdapter()
            binding.rvResult.adapter = usersAdapter
            usersAdapter!!.submitList(it)
            usersAdapter?.notifyDataSetChanged()
        }

    }
}