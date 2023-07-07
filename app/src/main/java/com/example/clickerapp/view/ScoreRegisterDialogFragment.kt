package com.example.clickerapp.view

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.clickerapp.databinding.FragmentScoreRegisterDialogBinding
import com.example.clickerapp.viewmodel.ScoreRegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScoreRegisterDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentScoreRegisterDialogBinding
    private val viewModel: ScoreRegisterViewModel by viewModel()
    private var time: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            time = it.getString(TIME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreRegisterDialogBinding.inflate(inflater, container, false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#56FFFFFF")))
        dialog?.setCancelable(false)



        /*val db = Room.databaseBuilder(
            requireContext().applicationContext,
            AppDatabase::class.java, "data-database"
        ).build()
        val userDao = db?.userDao()*/



        val intent = Intent(requireContext(), ResultActivity::class.java)
        binding.tvTime.text = time
        binding.btnSave.setOnClickListener {
            val name = binding.etEnterName.text.toString()
            /*GlobalScope.launch {
                val data = User(name,time!!)
                userDao?.insert(data)
            }*/
            viewModel.insertUser(name,time!!)
            startActivity(intent)
            dismiss()
            activity?.finish()

        }
        return binding.root
    }

    companion object {

        private const val TIME = "timer"
        @JvmStatic
        fun newInstance(timer: String) =
            ScoreRegisterDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(TIME, timer)
                    //putString(USER_NAME,userName)
                }
            }
    }
}