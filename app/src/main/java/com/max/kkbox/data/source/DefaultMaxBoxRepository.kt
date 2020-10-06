package com.max.kkbox.data.source


import com.max.kkbox.data.*

class DefaultMaxBoxRepository(private val remoteDataSource: MaxBoxDataSource
) : MaxBoxRepository {
    override suspend fun getNewReleaseAlbum(): MaxResult<List<Album>> {
        return remoteDataSource.getNewReleaseAlbum()
    }

    override suspend fun getFeaturedPlayLists(offset: Int): MaxResult<PlayListsResult> {
        return remoteDataSource.getFeaturedPlayLists(offset)
    }

    override suspend fun getRankPlayLists(): MaxResult<List<PlayLists>> {
        return remoteDataSource.getRankPlayLists()
    }

    override suspend fun getChartsTracks(id: String): MaxResult<List<Tracks>> {
        return remoteDataSource.getChartsTracks(id)
    }

    override suspend fun getAlbumsTracks(id: String): MaxResult<List<Tracks>> {
        return remoteDataSource.getAlbumsTracks(id)
    }

}
