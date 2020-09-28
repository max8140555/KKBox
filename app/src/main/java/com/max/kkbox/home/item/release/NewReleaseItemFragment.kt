package com.max.kkbox.home.item.release

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.max.kkbox.NavigationDirections
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

        binding.recyclerNewAlbum.adapter =
            NewAlbumItemAdapter(
                NewAlbumItemAdapter.OnClickListener {
                    viewModel.displayAlbumSongList(it)
                })

        binding.recyclerFeaturedPlaylist.adapter =
            FeaturedPlayListsItemAdapter(
                FeaturedPlayListsItemAdapter.OnClickListener {
                    viewModel.displayPlayListsSongList(it)
                })

        viewModel.navigateToAlbumSongList.observe(viewLifecycleOwner, Observer { album ->
            album?.let {
                findNavController().navigate(NavigationDirections.actionGlobalSongListFragment(it,null))
                viewModel.navigationLeave()
            }
        })
        viewModel.navigateToPlayListsSongList.observe(viewLifecycleOwner, Observer { playLists ->
            playLists?.let {
                findNavController().navigate(NavigationDirections.actionGlobalSongListFragment(null, it))
                viewModel.navigationLeave()
            }
        })

        return binding.root
    }


}