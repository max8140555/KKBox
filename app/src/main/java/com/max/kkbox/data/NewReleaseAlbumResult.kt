package com.max.kkbox.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewReleaseAlbumResult(
    val data: List<Album>,
    val paging: Paging,
    val summary: Summary,
    val error: Error?
) : Parcelable

@Parcelize
data class Paging(
    val offset: Int,
    val limit: Int,
    val previous: String?,
    val next: String?
) : Parcelable

@Parcelize
data class Summary(
    val total: Int
) : Parcelable

@Parcelize
data class Album(
    val id: String,
    val name: String,
    val url: String,
    val explicitness: Boolean,
    @Json(name = "available_territories")
    val availableTerritories: List<String>,
    @Json(name = "release_date")
    val releaseDate: String,
    val images: List<Image>,
    val artist: Artist
) : Parcelable

@Parcelize
data class Image(
    val height: Int,
    val width: Int,
    val url: String
) : Parcelable

@Parcelize
data class Artist(
    val id: String,
    val name: String,
    val url: String,
    val images: List<Image>
) : Parcelable

@Parcelize
data class Error(
    val message: String,
    val code: Int
) : Parcelable