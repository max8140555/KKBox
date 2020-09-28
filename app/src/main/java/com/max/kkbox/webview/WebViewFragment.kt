package com.max.kkbox.webview


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.max.kkbox.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWebViewBinding.inflate(inflater, container, false)

        val tracks =   WebViewFragmentArgs.fromBundle(requireArguments()).tracksKey
        binding.webView.loadUrl(tracks.url)

        return binding.root
    }

}