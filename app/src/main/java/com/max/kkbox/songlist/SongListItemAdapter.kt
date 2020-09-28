package com.max.kkbox.songlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max.kkbox.data.Tracks
import com.max.kkbox.databinding.ItemSongListBinding
import com.max.kkbox.util.bindImage


class SongListItemAdapter(
    private val onClickListener: OnClickListener,
    val viewModel: SongListViewModel
) :
    ListAdapter<Tracks, SongListItemAdapter.SongListItemViewHolder>(
        DiffCallback
    ) {

    class SongListItemViewHolder(private var binding: ItemSongListBinding) :
        RecyclerView.ViewHolder(binding.root) {


        @SuppressLint("SetTextI18n")
        fun bind(tracks: Tracks, viewModel: SongListViewModel) {
            binding.tracks = tracks

            if (viewModel.selectAlbum.value != null) {

                viewModel.selectAlbum.value?.let { album ->
                    bindImage(binding.image, album.images[0].url)
                    binding.textAlbumName.text = album.name
                    binding.textContext.text ="${album.artist.name}@${album.releaseDate}"
                }

            } else {

                viewModel.selectPlaylists.value?.let { playlists ->
                    bindImage(binding.image, tracks.album!!.images[0].url)
                    binding.textAlbumName.text = playlists.title
                    binding.textContext.text = "${tracks.album.artist.name}@${tracks.album.releaseDate}"
                }
            }

            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Tracks>() {
        override fun areItemsTheSame(
            oldItem: Tracks,
            newItem: Tracks
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Tracks,
            newItem: Tracks
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): SongListItemViewHolder {
        return SongListItemViewHolder(
            ItemSongListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SongListItemViewHolder, position: Int) {
        val tracks =
            getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(tracks)
        }
        holder.bind(tracks, viewModel)
    }

    class OnClickListener(val clickListener: (tracks: Tracks) -> Unit) {
        fun onClick(tracks: Tracks) = clickListener(tracks)
    }
}