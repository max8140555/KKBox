package com.max.kkbox.ext

import androidx.fragment.app.Fragment
import com.max.kkbox.MaxBoxApplication
import com.max.kkbox.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory{
    val repository = (requireContext().applicationContext as MaxBoxApplication).maxBoxRepository
    return ViewModelFactory(repository)
}