package com.max.kkbox.home.item

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.max.kkbox.R
import com.max.kkbox.data.Album
import com.max.kkbox.data.MaxBoxRepository
import com.max.kkbox.data.MaxResult
import com.max.kkbox.data.PlayLists
import com.max.kkbox.network.LoadApiStatus
import com.max.kkbox.util.Util
import com.max.kkbox.util.Util.getString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewReleaseItemViewModel(private val maxBoxRepository: MaxBoxRepository) : ViewModel() {

    private val _playLists = MutableLiveData<List<PlayLists>>()

    val playLists: LiveData<List<PlayLists>>
        get() = _playLists

    private val _listAlbum = MutableLiveData<List<Album>>()

    val listAlbum: LiveData<List<Album>>
        get() = _listAlbum

    // Handle leave login
    private val _leave = MutableLiveData<Boolean>()

    val leave: LiveData<Boolean>
        get() = _leave

    // status: The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<LoadApiStatus>()

    val status: LiveData<LoadApiStatus>
        get() = _status

    // error: The internal MutableLiveData that stores the error of the most recent request
    private val _error = MutableLiveData<String>()

    val error: LiveData<String>
        get() = _error

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        getNewReleaseAlbumResult()
        getFeaturedPlayListsResult()
    }

    private fun getNewReleaseAlbumResult() {

        coroutineScope.launch {

            _status.value = LoadApiStatus.LOADING
            // It will return Result object after Deferred flow
            when (val result = maxBoxRepository.getNewReleaseAlbum()){
                is MaxResult.Success-> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    _listAlbum.value = result.data
                    Log.d("getAlbum","${result.data}")
                    Log.d("getAlbumlist","${_listAlbum.value}")
                }
                is MaxResult.Fail -> {
                    _error.value = result.error
                    _status.value = LoadApiStatus.ERROR
                }
                is MaxResult.Error -> {
                    _error.value = result.exception.toString()
                    _status.value = LoadApiStatus.ERROR
                }
                else -> {
                    _error.value = getString(R.string.you_know_nothing)
                    _status.value = LoadApiStatus.ERROR
                }
            }
        }
    }

    private fun getFeaturedPlayListsResult() {

        coroutineScope.launch {

            _status.value = LoadApiStatus.LOADING
            // It will return Result object after Deferred flow
            when (val result = maxBoxRepository.getFeaturedPlayLists()){
                is MaxResult.Success-> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    _playLists.value = result.data
                    Log.d("PlayLists","${result.data}")
                    Log.d("getPlayLists","${_playLists.value}")
                }
                is MaxResult.Fail -> {
                    _error.value = result.error
                    _status.value = LoadApiStatus.ERROR
                }
                is MaxResult.Error -> {
                    _error.value = result.exception.toString()
                    _status.value = LoadApiStatus.ERROR
                }
                else -> {
                    _error.value = getString(R.string.you_know_nothing)
                    _status.value = LoadApiStatus.ERROR
                }
            }
        }
    }

}