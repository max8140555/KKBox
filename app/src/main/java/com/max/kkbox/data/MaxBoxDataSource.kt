package com.max.kkbox.data

interface MaxBoxDataSource {
    suspend fun getNewReleaseAlbum(): MaxResult<List<Album>>

    suspend fun getFeaturedPlayLists(offset: Int): MaxResult<PlayListsResult>

    suspend fun getRankPlayLists(): MaxResult<List<PlayLists>>

    suspend fun getChartsTracks(id: String): MaxResult<List<Tracks>>

    suspend fun getAlbumsTracks(id: String): MaxResult<List<Tracks>>
}
