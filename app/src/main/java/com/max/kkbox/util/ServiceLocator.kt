package com.max.kkbox.util

import androidx.annotation.VisibleForTesting
import com.max.kkbox.data.MaxBoxRepository
import com.max.kkbox.data.source.DefaultMaxBoxRepository
import com.max.kkbox.data.source.remote.MaxBoxRemoteDataSource

/**
 * A Service Locator for the [StylishRepository].
 */
object ServiceLocator {

    @Volatile
    var maxBoxRepository : MaxBoxRepository? = null
        @VisibleForTesting set

    fun provideTasksRepository(): MaxBoxRepository {
        synchronized(this) {
            return maxBoxRepository
                ?: maxBoxRepository
                ?: createStylishRepository()
        }
    }

    private fun createStylishRepository(): MaxBoxRepository {
        return DefaultMaxBoxRepository(
            MaxBoxRemoteDataSource
        )
    }

}