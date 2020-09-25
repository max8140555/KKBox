package com.max.kkbox.data

interface MaxBoxRepository {
    suspend fun getNewReleaseAlbum(): MaxResult<List<Album>>
}