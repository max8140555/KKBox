package com.max.kkbox.data.source.remote



import com.max.kkbox.R
import com.max.kkbox.data.*
import com.max.kkbox.network.MaxBoxApi
import com.max.kkbox.util.Logger
import com.max.kkbox.util.Util.getString
import com.max.kkbox.util.Util.isInternetConnected


object MaxBoxRemoteDataSource : MaxBoxDataSource {

    override suspend fun getNewReleaseAlbum(): MaxResult<List<Album>> {

        if (!isInternetConnected()) {
            return MaxResult.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            val chineseToken = "Cng5IUIQhxb8w1cbsz"
            // this will run on a thread managed by Retrofit
            val listResult = MaxBoxApi.retrofitService.getNewReleaseAlbum(chineseToken)

            listResult.error?.let {
                return MaxResult.Fail(it.message)
            }
            MaxResult.Success(listResult.data)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            MaxResult.Error(e)
        }
    }

    override suspend fun getFeaturedPlayLists(): MaxResult<List<PlayLists>> {
        if (!isInternetConnected()) {
            return MaxResult.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            // this will run on a thread managed by Retrofit
            val listResult = MaxBoxApi.retrofitService.getFeaturedPlayLists()

            listResult.error?.let {
                return MaxResult.Fail(it.message)
            }
            MaxResult.Success(listResult.data)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            MaxResult.Error(e)
        }
    }

    override suspend fun getRankPlayLists(): MaxResult<List<PlayLists>> {
        if (!isInternetConnected()) {
            return MaxResult.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            // this will run on a thread managed by Retrofit
            val listResult = MaxBoxApi.retrofitService.getRankPlayLists()

            listResult.error?.let {
                return MaxResult.Fail(it.message)
            }
            MaxResult.Success(listResult.data)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            MaxResult.Error(e)
        }
    }

    override suspend fun getChartsTracks(id: String): MaxResult<List<Tracks>> {
        if (!isInternetConnected()) {
            return MaxResult.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            // this will run on a thread managed by Retrofit
            val listResult = MaxBoxApi.retrofitService.getChartsTracks(id)

            listResult.error?.let {
                return MaxResult.Fail(it.message)
            }
            MaxResult.Success(listResult.data)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            MaxResult.Error(e)
        }
    }


    override suspend fun getAlbumsTracks(id: String): MaxResult<List<Tracks>> {
        if (!isInternetConnected()) {
            return MaxResult.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            // this will run on a thread managed by Retrofit
            val listResult = MaxBoxApi.retrofitService.getAlbumsTracks(id)

            listResult.error?.let {
                return MaxResult.Fail(it.message)
            }

            MaxResult.Success(listResult.data)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")

            MaxResult.Error(e)
        }
    }

}