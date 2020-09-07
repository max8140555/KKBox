package com.max.kkbox

import android.app.*
import kotlin.properties.Delegates


class KKBOXApplication : Application() {

//    val timeMasterRepository :TimeMasterRepository
//        get() = ServiceLocator.provideTasksRepository()

    companion object {
        var instance: KKBOXApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
