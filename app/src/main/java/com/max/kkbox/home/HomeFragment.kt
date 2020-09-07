package com.max.kkbox.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.max.kkbox.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        FragmentHomeBinding.inflate(inflater, container, false).apply {

            lifecycleOwner = viewLifecycleOwner
            viewpagerHome.let {
                tabsHome.setupWithViewPager(it)
                it.adapter = HomeAdapter(childFragmentManager)
                it.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabsHome))
            }
            return@onCreateView root
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}