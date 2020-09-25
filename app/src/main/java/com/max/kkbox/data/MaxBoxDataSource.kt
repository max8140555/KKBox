package com.max.kkbox.data

import android.net.Uri
import androidx.lifecycle.MutableLiveData


interface MaxBoxDataSource {
    suspend fun getNewReleaseAlbum(): MaxResult<List<Album>>
//
//    suspend fun postEvent(calendarEvent: CalendarEvent): Result<Boolean>
//
//    suspend fun postUser(user: User): Result<Boolean>
//
//    suspend fun postDate(myDate: MyDate): Result<Boolean>
//
//    suspend fun postFavorite(dateFavorite: DateFavorite): Result<Boolean>
//
//    suspend fun postCost(dateCost: DateCost): Result<Boolean>
//
//    suspend fun updateDate(myDate: MyDate): Result<Boolean>
//
//    suspend fun upUserExp(exp: Long): Result<Boolean>
//
//    suspend fun syncImage(uri: Uri): Result<String>
//
//    suspend fun handleFacebookAccessToken(token: AccessToken?): Result<FirebaseUser?>
//
//    fun getLiveAllEvent(): MutableLiveData<List<CalendarEvent>>
//
//    fun getLiveUser(): MutableLiveData<User>
//
//    fun getLiveMyDate(): MutableLiveData<List<MyDate>>
//
//    fun getLiveDateFavorite(): MutableLiveData<List<DateFavorite>>
//
//    fun getLiveDateCost(): MutableLiveData<List<DateCost>>
}
