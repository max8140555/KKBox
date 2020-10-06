package com.max.kkbox.home.item.release


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
import com.max.kkbox.util.Util.getString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewReleaseItemViewModel(private val maxBoxRepository: MaxBoxRepository) : ViewModel() {

    var inputOffset: Int? = 0

    private val _playLists = MutableLiveData<List<PlayLists>>()

    val playLists: LiveData<List<PlayLists>>
        get() = _playLists

    private val _listAlbum = MutableLiveData<List<Album>>()

    val listAlbum: LiveData<List<Album>>
        get() = _listAlbum

    private val _navigateToAlbumSongList = MutableLiveData<Album>()
    val navigateToAlbumSongList: LiveData<Album>
        get() = _navigateToAlbumSongList

    private val _navigateToPlayListsSongList = MutableLiveData<PlayLists>()
    val navigateToPlayListsSongList: LiveData<PlayLists>
        get() = _navigateToPlayListsSongList

    private val _status = MutableLiveData<LoadApiStatus>()

    val status: LiveData<LoadApiStatus>
        get() = _status

    private val _error = MutableLiveData<String>()

    val error: LiveData<String>
        get() = _error

    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        getNewReleaseAlbumResult()
        getFeaturedPlayListsResult(inputOffset)
    }

    private fun getNewReleaseAlbumResult() {

        coroutineScope.launch {

            _status.value = LoadApiStatus.LOADING
            // It will return Result object after Deferred flow
            when (val result = maxBoxRepository.getNewReleaseAlbum()) {
                is MaxResult.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE
                    _listAlbum.value = result.data
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

    fun getFeaturedPlayListsResult(offset: Int?, oldData: List<PlayLists>? = null) {

        coroutineScope.launch {

            _status.value = LoadApiStatus.LOADING
            // It will return Result object after Deferred flow
            when (val result = offset?.let { maxBoxRepository.getFeaturedPlayLists(it) }) {
                is MaxResult.Success -> {
                    _error.value = null
                    _status.value = LoadApiStatus.DONE

                    _playLists.value = when (oldData) {
                        null -> result.data.data
                        else -> oldData + result.data.data
                    }

                    val splitNext = result.data.paging.next?.split("&")
                    val splitAgain = splitNext?.get(1)?.split("offset=")
                    inputOffset = splitAgain?.get(1)?.toInt()
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

    fun displayAlbumSongList(album: Album) {
        _navigateToAlbumSongList.value = album
    }

    fun displayPlayListsSongList(playLists: PlayLists) {
        _navigateToPlayListsSongList.value = playLists
    }

    fun navigationLeave() {
        _navigateToAlbumSongList.value = null
        _navigateToPlayListsSongList.value = null
    }
}