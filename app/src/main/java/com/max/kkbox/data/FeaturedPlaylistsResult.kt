package com.max.kkbox.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayListsResult(
    val data: List<PlayLists>,
    val paging: Paging,
    val summary: Summary,
    val error: Error?
) : Parcelable


@Parcelize
data class PlayLists(
    val id: String,
    val title: String,
    val description: String,
    val url: String,
    val images: List<Image>,
    @Json(name = "updated_at")
    val updatedAt: String,
    val owner: Owner
) : Parcelable


@Parcelize
data class Owner(
    val id: String,
    val url: String,
    val name: String,
    val description: String,
    val images: List<Image>
) : Parcelable
