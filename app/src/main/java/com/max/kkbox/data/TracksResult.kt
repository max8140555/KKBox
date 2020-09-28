package com.max.kkbox.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TracksResult(
    val data: List<Tracks>,
    val paging: Paging,
    val summary: Summary,
    val error: Error?
) : Parcelable


@Parcelize
data class Tracks(
    val id: String,
    val name: String,
    val duration: Int,
    val isrc: String,
    val url: String,
    @Json(name = "track_number")
    val trackNumber: Int,
    val explicitness: Boolean,
    val available_territories: List<String>,
    val album: Album?
) : Parcelable

