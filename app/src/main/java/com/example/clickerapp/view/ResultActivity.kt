package com.example.clickerapp.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.clickerapp.database.AppDatabase
import com.example.clickerapp.databinding.ActivityResultBinding
import com.example.clickerapp.view.adapter.UsersAdapter
import com.example.clickerapp.viewmodel.ResultViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
            viewModel.onBackPress()
            finish()
        }

        /*val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "data-database"
        ).build()
        val userDao = db.userDao()*/

        viewModel.getUsers()
        viewModel.userList.observe(this){
            usersAdapter = UsersAdapter()
            binding.rvResult.adapter = usersAdapter
            usersAdapter!!.submitList(it)
            usersAdapter?.notifyDataSetChanged()
        }

        /*GlobalScope.launch {
            val allData = userDao.getAll()
            withContext(Dispatchers.Main) {
                usersAdapter = UsersAdapter()
                Log.d("MyTag",allData.toString())
                binding.rvResult.adapter = usersAdapter
                usersAdapter!!.submitList(allData)
                usersAdapter?.notifyDataSetChanged()
            }
        }*/
    }
}