package com.max.kkbox.home.item

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.max.kkbox.R
import com.max.kkbox.data.Album
import com.max.kkbox.data.MaxBoxRepository
import com.max.kkbox.data.MaxResult
import com.max.kkbox.network.LoadApiStatus
import com.max.kkbox.util.Util
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RankItemViewModel(private val maxBoxRepository: MaxBoxRepository) : ViewModel() {
}