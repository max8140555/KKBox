package com.max.kkbox.data

import android.net.Uri
import androidx.lifecycle.MutableLiveData


interface MaxBoxDataSource {
    suspend fun getNewReleaseAlbum(): MaxResult<List<Album>>

    suspend fun getFeaturedPlayLists(): MaxResult<List<PlayLists>>

    suspend fun getRankPlayLists(): MaxResult<List<PlayLists>>
}
