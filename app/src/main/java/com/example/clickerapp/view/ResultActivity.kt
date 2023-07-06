package com.example.clickerapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickerapp.databinding.ActivityResultBinding
import com.example.clickerapp.model.User
import com.example.clickerapp.view.adapter.UsersAdapter
import com.example.clickerapp.viewmodel.ResultViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private val viewModel: ResultViewModel by viewModel()
    private var usersAdapter: UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.backPressed.observe(this) {
            onBackPressed()
        }

        binding.ivBackButton.setOnClickListener {
            viewModel.onBackPress()
        }

        val time: String = intent.getStringExtra("TIMER")?: "null"

        val userList = arrayListOf<User>()
        userList.add(User(1,"farida", time))

        usersAdapter = UsersAdapter(userList)
        binding.rvResult.adapter = usersAdapter
        usersAdapter?.notifyDataSetChanged()
    }
}