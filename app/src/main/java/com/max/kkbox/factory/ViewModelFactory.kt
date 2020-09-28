package com.max.kkbox.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.max.kkbox.data.MaxBoxRepository
import com.max.kkbox.home.item.release.NewReleaseItemViewModel
import com.max.kkbox.home.item.rank.RankItemViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val maxBoxRepository: MaxBoxRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(NewReleaseItemViewModel::class.java) ->
                    NewReleaseItemViewModel(
                        maxBoxRepository
                    )
                isAssignableFrom(RankItemViewModel::class.java) ->
                    RankItemViewModel(
                        maxBoxRepository
                    )
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}