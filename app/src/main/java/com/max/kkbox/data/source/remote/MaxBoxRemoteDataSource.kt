package com.max.kkbox.data.source.remote


import com.max.kkbox.data.MaxBoxDataSource

/**
 * Created by Wayne Chen in Jul. 2019.
 *
 * Implementation of the Stylish source that from network.
 */
object MaxBoxRemoteDataSource : MaxBoxDataSource {

//    override suspend fun getMarketingHots(): Result<List<HomeItem>> {
//
//        if (!isInternetConnected()) {
//            return Result.Fail(getString(R.string.internet_not_connected))
//        }
//
//        return try {
//            // this will run on a thread managed by Retrofit
//            val listResult = StylishApi.retrofitService.getMarketingHots()
//
//            listResult.error?.let {
//                return Result.Fail(it)
//            }
//            Result.Success(listResult.toHomeItems())
//
//        } catch (e: Exception) {
//            Logger.w("[${this::class.simpleName}] exception=${e.message}")
//            Result.Error(e)
//        }
//    }

}

