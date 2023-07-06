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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"

class ScoreRegisterDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentScoreRegisterDialogBinding

    // TODO: Rename and change types of parameters
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
        binding = FragmentScoreRegisterDialogBinding.inflate(inflater,container,false)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#56FFFFFF")))
        dialog?.setCancelable(false)
        //dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.tvTime.text = time
        binding.btnSave.setOnClickListener {
            val intent = Intent(requireContext(), ResultActivity::class.java)
            intent.putExtra("TIMER",time)
            startActivity(intent)
            dismiss()
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