package com.example.presentation.manager

import android.util.Log
import com.example.core.BuildConfig.DEBUG

//object LogManager {
//    fun logD(tag: String, message: String) {
////        if (DEBUG) {
////            Log.d(tag, message)
////        }
//        Log.d(tag, message)
//
//    }
//
//    fun logE(tag: String, message: String) {
////        if (DEBUG) {
////            Log.e(tag, message)
////        }
//        Log.e(this::class.java.simpleName, message)
//    }
//}

fun Any.logD(message: String) {
    Log.d(this::class.java.simpleName, message)
}

fun Any.logE(message: String) {
    Log.e(this::class.java.simpleName, message)
}
