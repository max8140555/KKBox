package com.max.kkbox.util


import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.max.kkbox.R
import com.max.kkbox.data.Album
import com.max.kkbox.home.item.NewAlbumItemAdapter


@BindingAdapter("albumItems")
fun bindRecyclerViewWithAlbumItems(recyclerView: RecyclerView, albumItems: List<Album>?) {
    albumItems?.let {
        Log.d("9527","$albumItems")
        recyclerView.adapter?.apply {
            when (this) {
                is NewAlbumItemAdapter -> {
                    submitList(it)
                }
            }
        }
    }
}

@BindingAdapter("albumImage")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.white_background))
            .into(imgView)
    }
}

