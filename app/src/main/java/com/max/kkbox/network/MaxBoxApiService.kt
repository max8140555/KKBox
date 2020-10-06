package com.max.kkbox.network


import com.max.kkbox.data.NewReleaseAlbumResult
import com.max.kkbox.data.PlayListsResult
import com.max.kkbox.data.TracksResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


private const val HOST_NAME = "api.kkbox.com"
private const val API_VERSION = "v1.1"
private const val BASE_URL = "https://$HOST_NAME/$API_VERSION/"

private const val BEARER_TOKEN = "Bearer 7NG48u1cYwvcTQQmMiKetA=="
private const val TERRITORY = "TW"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()


interface MaxBoxApiService {

    @GET("new-release-categories/{ID}/albums")
    suspend fun getNewReleaseAlbum(
        @Path("ID") categoryId: String,
        @Query("territory") territory: String = TERRITORY,
        @Header("Authorization") bearer: String? = BEARER_TOKEN
    ): NewReleaseAlbumResult

    @GET("featured-playlists")
    suspend fun getFeaturedPlayLists(
        @Query("territory") territory: String = TERRITORY,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int? = 10,
        @Header("Authorization") bearer: String? = BEARER_TOKEN
    ): PlayListsResult

    @GET("charts")
    suspend fun getRankPlayLists(
        @Query("territory") territory: String = TERRITORY,
        @Header("Authorization") bearer: String? = BEARER_TOKEN
    ): PlayListsResult

    @GET("charts/{ID}/tracks")
    suspend fun getChartsTracks(
        @Path("ID") Id: String,
        @Query("territory") territory: String = TERRITORY,
        @Header("Authorization") bearer: String? = BEARER_TOKEN
    ): TracksResult

    @GET("albums/{ID}/tracks")
    suspend fun getAlbumsTracks(
        @Path("ID") Id: String,
        @Query("territory") territory: String = TERRITORY,
        @Header("Authorization") bearer: String? = BEARER_TOKEN
    ): TracksResult
}

object MaxBoxApi {
    val retrofitService: MaxBoxApiService by lazy { retrofit.create(MaxBoxApiService::class.java) }
}