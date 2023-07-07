package com.example.clickerapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.clickerapp.App
import com.example.clickerapp.database.AppDatabase
import com.example.clickerapp.database.User
import com.example.clickerapp.databinding.FragmentScoreRegisterDialogBinding
import com.example.clickerapp.view.adapter.UsersAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScoreRegisterDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentScoreRegisterDialogBinding
    private var time: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            time = it.getString("TIMER", "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentScoreRegisterDialogBinding.inflate(inflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#56FFFFFF")))
        dialog?.setCancelable(false)
        //dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))



        val db = Room.databaseBuilder(
            requireContext().applicationContext,
            AppDatabase::class.java, "data-database"
        ).build()
        val userDao = db?.userDao()



        val intent = Intent(requireContext(), ResultActivity::class.java)
        binding.tvTime.text = time
        binding.btnSave.setOnClickListener {
            val name = binding.etEnterName.text.toString()
            GlobalScope.launch {
                val data = User(name,time!!)
                userDao?.insert(data)
            }
            startActivity(intent)
            dismiss()
            activity?.finish()

        }
        return binding.root
    }

    companion object {

        private const val TIMER = "timer"
        private const val USER_NAME = "user_name"
        @JvmStatic
        fun newInstance(timer: String) =
            ScoreRegisterDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(TIMER, timer)
                    //putString(USER_NAME,userName)
                }
            }
    }
}