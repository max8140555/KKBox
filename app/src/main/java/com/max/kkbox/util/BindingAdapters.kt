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
import com.max.kkbox.home.item.NewAlbumItemAdapter
import com.max.kkbox.home.item.FeaturedPlayListsItemAdapter
import com.max.kkbox.home.item.RankPlayListsItemAdapter


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

@BindingAdapter("featuredPlayListsItems")
fun bindRecyclerViewWithFeaturedPlayListsItems(recyclerView: RecyclerView, playListsItems: List<PlayLists>?) {
    playListsItems?.let {

        recyclerView.adapter?.apply {
            when (this) {
                is FeaturedPlayListsItemAdapter -> {
                    submitList(it)
                }
            }
        }
    }
}

@BindingAdapter("rankPlayListsItems")
fun bindRecyclerViewWithRankPlayListsItems(recyclerView: RecyclerView, playListsItems: List<PlayLists>?) {
    playListsItems?.let {

        recyclerView.adapter?.apply {
            when (this) {
                is RankPlayListsItemAdapter -> {
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
            .override(100, 100)
            .into(imgView)
    }
}

