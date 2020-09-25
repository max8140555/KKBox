package com.max.kkbox.util

import android.util.Log
import com.max.kkbox.BuildConfig

object Logger {

    private const val TAG = "Max-MaxBox"

    fun v(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.v(TAG, content) }
    fun d(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.d(TAG, content) }
    fun i(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.i(TAG, content) }
    fun w(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.w(TAG, content) }
    fun e(content: String) { if (BuildConfig.LOGGER_VISIABLE) Log.e(TAG, content) }

}