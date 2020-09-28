package com.max.kkbox.util


import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.max.kkbox.R
import com.max.kkbox.data.Album
import com.max.kkbox.data.PlayLists
import com.max.kkbox.data.Tracks
import com.max.kkbox.home.item.release.NewAlbumItemAdapter
import com.max.kkbox.home.item.release.FeaturedPlayListsItemAdapter
import com.max.kkbox.home.item.rank.RankPlayListsItemAdapter
import com.max.kkbox.songlist.SongListItemAdapter

@BindingAdapter("albumItems")
fun bindRecyclerViewWithAlbumItems(recyclerView: RecyclerView, albumItems: List<Album>?) {
    albumItems?.let {

        recyclerView.adapter?.apply {
            when (this) {
                is NewAlbumItemAdapter -> {
                    submitList(it)
                }
            }
        }
    }
}

@BindingAdapter("playListsItems")
fun bindRecyclerViewWithFeaturedPlayListsItems(recyclerView: RecyclerView, playListsItems: List<PlayLists>?) {
    playListsItems?.let {

        recyclerView.adapter?.apply {
            when (this) {
                is FeaturedPlayListsItemAdapter -> {
                    submitList(it)
                }
                is RankPlayListsItemAdapter -> {
                    submitList(it)
                }
            }
        }
    }
}

@BindingAdapter("listTracksItems")
fun bindRecyclerViewWithListTracksItems(recyclerView: RecyclerView, listTracksItems: List<Tracks>?) {
    listTracksItems?.let {

        recyclerView.adapter?.apply {
            when (this) {
                is SongListItemAdapter -> {
                    submitList(it)
                }
            }
        }
    }
}


@BindingAdapter("myImage")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.white_background))
            .centerCrop()
            .override(100, 100)
            .into(imgView)
    }
}


@BindingAdapter("myBigImage")
fun bindBigImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()

        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.white_background))
            .centerCrop()
            .into(imgView)
    }
}
