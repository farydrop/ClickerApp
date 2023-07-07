package com.example.clickerapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.clickerapp.R
import com.example.clickerapp.databinding.ActivityStartBinding
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
            val bundle = Bundle()
            bundle.putString("TIMER", it)
            dialog.arguments = bundle
            dialog.show(this@StartActivity.supportFragmentManager, "ScoreRegisterDialog")
            /*supportFragmentManager.beginTransaction()
                .replace(R.id.scoreContainer, ScoreRegisterDialogFragment())
                .commit()*/
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