package com.max.kkbox.home.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.max.kkbox.databinding.FragmentNewReleaseItemBinding
import com.max.kkbox.ext.getVmFactory




class NewReleaseItemFragment() : Fragment() {

    private val viewModel by viewModels<NewReleaseItemViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentNewReleaseItemBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.recyclerNewAlbum.adapter = NewAlbumItemAdapter(NewAlbumItemAdapter.OnClickListener{

        })

        return binding.root
    }


}