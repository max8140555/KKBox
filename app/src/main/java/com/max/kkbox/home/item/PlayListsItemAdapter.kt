package com.max.kkbox.home.item

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max.kkbox.data.PlayLists
import com.max.kkbox.databinding.ItemFeaturedPlaylistBinding


class PlayListsItemAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<PlayLists, PlayListsItemAdapter.PlayListsItemViewHolder>(
        DiffCallback
    ) {

    class PlayListsItemViewHolder(private var binding: ItemFeaturedPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {


        @SuppressLint("SetTextI18n")
        fun bind(playLists: PlayLists) {
            val splitUpdate = playLists.updatedAt.split("T")
            binding.playLists = playLists


            binding.textContext.text = "${playLists.owner.name}@${splitUpdate[0]}"


            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PlayLists>() {
        override fun areItemsTheSame(
            oldItem: PlayLists,
            newItem: PlayLists
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: PlayLists,
            newItem: PlayLists
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): PlayListsItemViewHolder {
        return PlayListsItemViewHolder(
            ItemFeaturedPlaylistBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayListsItemViewHolder, position: Int) {
        val playList =
            getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(playList)
        }
        holder.bind(playList)
    }

    class OnClickListener(val clickListener: (playLists: PlayLists) -> Unit) {
        fun onClick(playLists: PlayLists) = clickListener(playLists)
    }
}