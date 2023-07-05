package com.example.clickerapp.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import com.example.clickerapp.R
import com.example.clickerapp.databinding.ActivityStartBinding
import com.example.clickerapp.model.Ball
import com.example.clickerapp.viewmodel.StartViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding
    private val viewModel: StartViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.runTimer()

        viewModel.imageState.observe(this) {
            binding.ivBall.setImageResource(it)
        }

        viewModel.backPressed.observe(this){
            onBackPressed()
        }

        viewModel.timerState.observe(this){
            binding.tvStartTimer.text = it
        }

        viewModel.showDialogFragment.observe(this) {
            val dialog = ScoreRegisterDialogFragment()
            dialog.show(this@StartActivity.supportFragmentManager, "ScoreRegisterDialog")
        }

        binding.ivBackButton.setOnClickListener {
            viewModel.onBackPress()
        }

        binding.ivBall.setOnClickListener {
            binding.ivClick.visibility = View.INVISIBLE
            viewModel.ballButtonTapped()
        }
        viewModel.updateBackgroundImage()

    }
}