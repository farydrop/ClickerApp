package com.example.clickerapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickerapp.databinding.ActivityPoliticBinding

class PoliticActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPoliticBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPoliticBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackButton.setOnClickListener {
            finish()
        }
    }
}