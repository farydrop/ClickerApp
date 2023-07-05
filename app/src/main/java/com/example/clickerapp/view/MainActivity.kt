package com.example.clickerapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickerapp.databinding.ActivityMainBinding
import com.example.clickerapp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.showStartActivity.observe(this){
            startActivity(Intent(this@MainActivity, StartActivity::class.java))
        }

        viewModel.showResultActivity.observe(this){
            startActivity(Intent(this@MainActivity, ResultActivity::class.java))
        }

        viewModel.showPoliticActivity.observe(this){
            startActivity(Intent(this@MainActivity, PoliticActivity::class.java))
        }

        viewModel.closeApp.observe(this){
            finish()
        }

        binding.btnStart.setOnClickListener{
            viewModel.onStartClick()
        }

        binding.btnResult.setOnClickListener{
            viewModel.onResultClick()
        }

        binding.dtnPolitic.setOnClickListener {
            viewModel.onPoliticClick()
        }

        binding.btnQuit.setOnClickListener {
            viewModel.onAppClose()
        }

    }
}