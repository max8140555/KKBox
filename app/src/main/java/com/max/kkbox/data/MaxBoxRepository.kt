package com.max.kkbox.data

interface MaxBoxRepository {
    suspend fun getNewReleaseAlbum(): MaxResult<List<Album>>

    suspend fun getFeaturedPlayLists(): MaxResult<List<PlayLists>>

    suspend fun getRankPlayLists(): MaxResult<List<PlayLists>>
}