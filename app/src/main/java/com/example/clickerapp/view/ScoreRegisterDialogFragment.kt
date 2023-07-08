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
    private var name: String? = null


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

        binding.tvTime.text = time
        binding.btnSave.setOnClickListener {
            name = binding.etEnterName.text.toString()
            viewModel.insertUser(name!!, time!!)
            startActivity(Intent(requireContext(), ResultActivity::class.java))
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
                }
            }
    }
}