package com.max.kkbox.ext

import androidx.fragment.app.Fragment
import com.max.kkbox.MaxBoxApplication
import com.max.kkbox.data.Album
import com.max.kkbox.data.PlayLists
import com.max.kkbox.factory.ArgsStringViewModelFactory
import com.max.kkbox.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as MaxBoxApplication).maxBoxRepository
    return ViewModelFactory(repository)
}

fun Fragment.getVmFactory(album: Album?, playLists: PlayLists?): ArgsStringViewModelFactory {
    val repository = (requireContext().applicationContext as MaxBoxApplication).maxBoxRepository
    return ArgsStringViewModelFactory(repository, album, playLists)
}
