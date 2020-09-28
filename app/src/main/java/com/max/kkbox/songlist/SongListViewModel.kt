package com.max.kkbox.songlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.max.kkbox.R
import com.max.kkbox.data.*
import com.max.kkbox.network.LoadApiStatus
import com.max.kkbox.util.Util
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SongListViewModel(
    private val maxBoxRepository: MaxBoxRepository,
    album: Album?,
    playLists: PlayLists?
) : ViewModel() {

    private val _selectAlbum = MutableLiveData<Album>().apply {
        value = album
    }

    val selectAlbum: LiveData<Album>
        get() = _selectAlbum

    private val _selectPlaylists = MutableLiveData<PlayLists>().apply {
        value = playLists
    }

    val selectPlaylists: LiveData<PlayLists>
        get() = _selectPlaylists

    private val _listTracks = MutableLiveData<List<Tracks>>()

    val listTracks: LiveData<List<Tracks>>
        get() = _listTracks

    private val _navigateToWebView = MutableLiveData<Tracks>()

    val navigateToWebView: LiveData<Tracks>
        get() = _navigateToWebView

    private val _status = MutableLiveData<LoadApiStatus>()

    val status: LiveData<LoadApiStatus>
        get() = _status

    private val _error = MutableLiveData<String>()

    val error: LiveData<String>
        get() = _error

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        if (album != null) {
            getAlbumsTracksResult(album.id)
        } else {
            playLists?.let {
                getChartsTracksResult(it.id)
            }
        }
    }

    private fun getAlbumsTracksResult(id: String) {

        coroutineScope.launch {

            _status.value = LoadApiStatus.LOADING

            when (val result = maxBoxRepository.getAlbumsTracks(id)) {
                is MaxResult.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    _listTracks.value = result.data
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
                    _error.value = Util.getString(R.string.you_know_nothing)
                    _status.value = LoadApiStatus.ERROR
                }
            }
        }
    }

    private fun getChartsTracksResult(id: String) {

        coroutineScope.launch {
            _status.value = LoadApiStatus.LOADING

            when (val result = maxBoxRepository.getChartsTracks(id)) {
                is MaxResult.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    _listTracks.value = result.data
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
                    _error.value = Util.getString(R.string.you_know_nothing)
                    _status.value = LoadApiStatus.ERROR
                }
            }
        }
    }

}