package com.max.kkbox.data.source


import com.max.kkbox.data.Album
import com.max.kkbox.data.MaxBoxDataSource
import com.max.kkbox.data.MaxBoxRepository
import com.max.kkbox.data.MaxResult

class DefaultMaxBoxRepository(private val remoteDataSource: MaxBoxDataSource
) : MaxBoxRepository {
    override suspend fun getNewReleaseAlbum(): MaxResult<List<Album>> {
        return remoteDataSource.getNewReleaseAlbum()
    }

}
