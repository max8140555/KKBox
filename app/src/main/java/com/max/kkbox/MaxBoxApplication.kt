package com.max.kkbox

import android.app.*
import com.max.kkbox.data.MaxBoxRepository
import com.max.kkbox.util.ServiceLocator
import kotlin.properties.Delegates


class MaxBoxApplication : Application() {

    val maxBoxRepository : MaxBoxRepository
        get() = ServiceLocator.provideTasksRepository()

    companion object {
        var instance: MaxBoxApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
