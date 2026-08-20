package com.example.presentation.screen.main

import android.util.Log
import com.example.common.DSViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(

): DSViewModel() {
    fun test() {
        logD("logger test")
    }
}