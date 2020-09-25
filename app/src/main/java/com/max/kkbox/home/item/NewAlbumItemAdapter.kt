package com.max.kkbox.home.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max.kkbox.data.Album
import com.max.kkbox.databinding.ItemNewAlbumBinding

class NewAlbumItemAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Album, NewAlbumItemAdapter.NewAlbumItemViewHolder>(
        DiffCallback
    ) {

    class NewAlbumItemViewHolder(private var binding: ItemNewAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            binding.album = album



            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(
            oldItem: Album,
            newItem: Album
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Album,
            newItem: Album
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): NewAlbumItemViewHolder {
        return NewAlbumItemViewHolder(
            ItemNewAlbumBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NewAlbumItemViewHolder, position: Int) {
        val album =
            getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(album)
        }
        holder.bind(album)
    }

    class OnClickListener(val clickListener: (album: Album) -> Unit) {
        fun onClick(album: Album) = clickListener(album)
    }
}