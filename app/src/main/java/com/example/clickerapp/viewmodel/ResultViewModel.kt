package com.example.clickerapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clickerapp.common.SingleLiveDataEmpty
import com.example.clickerapp.model.User

class ResultViewModel: ViewModel() {

    val backPressed = SingleLiveDataEmpty()
    val userState = MutableLiveData<ArrayList<User>>()



    fun onBackPress() {
        backPressed.call()
    }
}