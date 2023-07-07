package com.example.clickerapp.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clickerapp.R
import com.example.clickerapp.common.SingleLiveData
import com.example.clickerapp.common.SingleLiveDataEmpty
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.schedule

class StartViewModel : ViewModel() {

    val imageState = MutableLiveData<Int>()
    val timerState = MutableLiveData<String>()
    val backPressed = SingleLiveDataEmpty()
    val showDialogFragment = SingleLiveData<String>()
    //private val data = ArrayList<User>()
    private var backgroundImageIndex = 0
    private var buttonPressCount = 0
    private val timer = Timer()
    private val ballsImage = arrayListOf<Int>(
        R.drawable.ball_1,
        R.drawable.ball_2
        /*R.drawable.ball_3,
        R.drawable.ball_4,
        R.drawable.ball_5,
        R.drawable.ball_6,
        R.drawable.ball_7,
        R.drawable.ball_8,
        R.drawable.ball_9,
        R.drawable.ball_10,
        R.drawable.ball_11,
        R.drawable.ball_12,
        R.drawable.ball_13,
        R.drawable.ball_14,
        R.drawable.ball_15,
        R.drawable.ball_16,
        R.drawable.ball_17,
        R.drawable.ball_18,
        R.drawable.ball_19,
        R.drawable.ball_20,
        R.drawable.ball_21,
        R.drawable.ball_22,
        R.drawable.ball_23,
        R.drawable.ball_24,
        R.drawable.ball_25,
        R.drawable.ball_26,
        R.drawable.ball_27,
        R.drawable.ball_28,
        R.drawable.ball_29,
        R.drawable.ball_30*/
    )
    private val boomImage =
        arrayListOf<Int>(R.drawable.boom_1, R.drawable.boom_2, R.drawable.boom_3, R.drawable.boom_4)
    private var currentBoomIndex = 0
    private var seconds: Int = 0
    private var isRunning: Boolean = true


    fun onBackPress() {
        backPressed.call()
    }

    fun ballButtonTapped() {
        buttonPressCount++

        if (buttonPressCount == 3) {
            buttonPressCount = 0
            changeBackgroundImage()
        }
    }

    private fun changeBackgroundImage() {
        backgroundImageIndex++
        if (backgroundImageIndex >= ballsImage.size) {
            backgroundImageIndex = 0
            boom()
            isRunning = false
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({ showDialogFragment.value = timerState.value }, 1000)
        }

        updateBackgroundImage()
    }

    fun updateBackgroundImage() {
        val imageName = ballsImage[backgroundImageIndex]
        imageState.value = imageName
    }

    private fun boom() {
        timer.schedule(0, 150) {
            // Ваш код для смены изображения
            // Например, здесь можно использовать библиотеку для работы с изображениями
            // и установить новое изображение на нужный элемент интерфейса
            val currentImage = boomImage[currentBoomIndex]
            // Пример вывода текущего изображения
            viewModelScope.launch {
                imageState.value = currentImage
            }
            // Увеличиваем индекс для перехода к следующему изображению
            currentBoomIndex++
            if (currentBoomIndex >= boomImage.size) {
                timer.cancel() // Если достигли конца списка, переходим к началу
            }
        }
    }

    fun runTimer() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                //val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                val time = String.format("%02d:%02d", minutes, secs)
                //val timerTextView = findViewById<TextView>(R.id.timerTextView)
                timerState.value = time
                //binding.tvStartTimer.text = time
                if (isRunning) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

}