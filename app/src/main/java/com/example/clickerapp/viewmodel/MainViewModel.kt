package com.example.clickerapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.clickerapp.common.SingleLiveDataEmpty

class MainViewModel: ViewModel() {

    val showStartActivity = SingleLiveDataEmpty()
    val showResultActivity = SingleLiveDataEmpty()
    val showPoliticActivity = SingleLiveDataEmpty()
    val closeApp = SingleLiveDataEmpty()

    fun onStartClick() {
        showStartActivity.call()
    }

    fun onResultClick() {
        showResultActivity.call()
    }

    fun onPoliticClick() {
        showPoliticActivity.call()
    }

    fun onAppClose() {
        closeApp.call()
    }
}