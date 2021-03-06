package com.max.kkbox.home.item.rank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.max.kkbox.NavigationDirections
import com.max.kkbox.databinding.FragmentRankItemBinding
import com.max.kkbox.ext.getVmFactory
import com.max.kkbox.home.item.release.FeaturedPlayListsItemAdapter
import com.max.kkbox.songlist.SongListFragmentArgs


class RankItemFragment() : Fragment() {

    private val viewModel by viewModels<RankItemViewModel> { getVmFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentRankItemBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel =viewModel

        binding.recyclerRankPlaylist.adapter =
            RankPlayListsItemAdapter(
                RankPlayListsItemAdapter.OnClickListener {
                    findNavController().navigate(NavigationDirections.actionGlobalSongListFragment(null, it))
                })

        return binding.root
    }


}