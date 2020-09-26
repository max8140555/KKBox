package com.max.kkbox.data.source


import com.max.kkbox.data.*

class DefaultMaxBoxRepository(private val remoteDataSource: MaxBoxDataSource
) : MaxBoxRepository {
    override suspend fun getNewReleaseAlbum(): MaxResult<List<Album>> {
        return remoteDataSource.getNewReleaseAlbum()
    }

    override suspend fun getFeaturedPlayLists(): MaxResult<List<PlayLists>> {
        return remoteDataSource.getFeaturedPlayLists()
    }

}
