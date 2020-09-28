package com.max.kkbox.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.max.kkbox.data.Album
import com.max.kkbox.data.MaxBoxRepository
import com.max.kkbox.data.PlayLists
import com.max.kkbox.songlist.SongListViewModel

@Suppress("UNCHECKED_CAST")
class ArgsStringViewModelFactory constructor(
    private val maxBoxRepository: MaxBoxRepository,
    val album: Album?,
    val playLists: PlayLists?
) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(SongListViewModel::class.java) ->
                    SongListViewModel(
                        maxBoxRepository, album, playLists
                    )
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}