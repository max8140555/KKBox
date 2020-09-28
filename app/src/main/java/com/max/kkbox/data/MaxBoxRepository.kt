package com.max.kkbox.data

interface MaxBoxRepository {
    suspend fun getNewReleaseAlbum(): MaxResult<List<Album>>

    suspend fun getFeaturedPlayLists(): MaxResult<List<PlayLists>>

    suspend fun getRankPlayLists(): MaxResult<List<PlayLists>>

    suspend fun getChartsTracks(id: String): MaxResult<List<Tracks>>

    suspend fun getAlbumsTracks(id: String): MaxResult<List<Tracks>>

}