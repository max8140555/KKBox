package com.max.kkbox.songlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.max.kkbox.NavigationDirections
import com.max.kkbox.databinding.FragmentSongListBinding
import com.max.kkbox.ext.getVmFactory
import com.max.kkbox.util.bindBigImage

class SongListFragment : Fragment() {

    private val viewModel by viewModels<SongListViewModel> {
        getVmFactory(
            SongListFragmentArgs.fromBundle(requireArguments()).albumKey,
            SongListFragmentArgs.fromBundle(requireArguments()).playListsKey

        )
    }
    lateinit var binding: FragmentSongListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSongListBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.recyclerSongList.adapter =
            SongListItemAdapter(
                SongListItemAdapter.OnClickListener {
                    findNavController().navigate(NavigationDirections.actionGlobalWebViewFragment(it))
                }, viewModel)


        viewModel.selectAlbum.observe(viewLifecycleOwner, Observer { selectAlbum ->
            selectAlbum?.let {
                bindBigImage(binding.imageAlbum, it.images[1].url)
            }
        })

        viewModel.selectPlaylists.observe(viewLifecycleOwner, Observer { selectPlaylists ->
            selectPlaylists?.let {
                bindBigImage(binding.imageAlbum, it.images[1].url)
            }
        })

        return binding.root
    }

}