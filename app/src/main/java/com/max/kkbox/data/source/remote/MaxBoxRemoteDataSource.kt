package com.max.kkbox.data.source.remote


import android.util.Log
import com.max.kkbox.R
import com.max.kkbox.data.Album
import com.max.kkbox.data.MaxBoxDataSource
import com.max.kkbox.data.MaxResult
import com.max.kkbox.network.MaxBoxApi
import com.max.kkbox.util.Logger
import com.max.kkbox.util.Util.getString
import com.max.kkbox.util.Util.isInternetConnected


object MaxBoxRemoteDataSource : MaxBoxDataSource {

    override suspend fun getNewReleaseAlbum(): MaxResult<List<Album>> {

        if (!isInternetConnected()) {
            Log.d("Max1","1")
            return MaxResult.Fail(getString(R.string.internet_not_connected))
        }

        return try {
            val chineseToken = "Cng5IUIQhxb8w1cbsz"
            // this will run on a thread managed by Retrofit
            val listResult = MaxBoxApi.retrofitService.getNewReleaseAlbum(chineseToken)

            listResult.error?.let {
                Log.d("Max2","2")
                return MaxResult.Fail(it.message)
            }
            Log.d("Max3","3")
            MaxResult.Success(listResult.data)

        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            Log.d("Max4","4")
            Log.d("Max4","$e")
            MaxResult.Error(e)
        }
    }

}

