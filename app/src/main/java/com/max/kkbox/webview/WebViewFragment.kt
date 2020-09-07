package com.max.kkbox.webview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.max.kkbox.R

class WebViewFragment : Fragment() {

    companion object {
        fun newInstance() = WebViewFragment()
    }

    private lateinit var viewModel: WebViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WebViewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}