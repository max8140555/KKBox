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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RankItemViewModel(private val maxBoxRepository: MaxBoxRepository) : ViewModel() {

    private val _playLists = MutableLiveData<List<PlayLists>>()

    val playLists: LiveData<List<PlayLists>>
        get() = _playLists

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
        getRankPlayListsResult()
    }

    private fun getRankPlayListsResult() {

        coroutineScope.launch {

            _status.value = LoadApiStatus.LOADING
            // It will return Result object after Deferred flow
            when (val result = maxBoxRepository.getRankPlayLists()){
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
                    _error.value = Util.getString(R.string.you_know_nothing)
                    _status.value = LoadApiStatus.ERROR
                }
            }
        }
    }

}