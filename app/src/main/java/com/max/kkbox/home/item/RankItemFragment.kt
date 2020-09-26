package com.max.kkbox.home.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.max.kkbox.databinding.FragmentNewReleaseItemBinding
import com.max.kkbox.databinding.FragmentRankItemBinding
import com.max.kkbox.ext.getVmFactory
import com.max.kkbox.home.HomeTypeFilter



class RankItemFragment() : Fragment() {


    private val viewModel by viewModels<RankItemViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentRankItemBinding.inflate(inflater, container, false)

//        binding.lifecycleOwner = viewLifecycleOwner
//
//        binding.recyclerFeaturedPlaylist.adapter = RankItemAdapter(RankItemAdapter.OnClickListener{
//
//        })
        return binding.root
    }


}