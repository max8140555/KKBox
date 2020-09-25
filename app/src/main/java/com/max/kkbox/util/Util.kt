package com.max.kkbox.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.max.kkbox.MaxBoxApplication


object Util {

    fun isInternetConnected(): Boolean {
        val cm = MaxBoxApplication.instance
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

    fun getString(resourceId: Int): String {
        return MaxBoxApplication.instance.getString(resourceId)
    }

}
