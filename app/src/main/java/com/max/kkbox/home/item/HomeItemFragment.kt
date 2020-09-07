package com.max.kkbox.home.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.max.kkbox.databinding.FragmentHomeItemBinding
import com.max.kkbox.home.HomeTypeFilter



class HomeItemFragment(private val homeType: HomeTypeFilter) : Fragment() {


//    private val viewModel by viewModels<ProfileItemViewModel> { getVmFactory(homeType) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeItemBinding.inflate(inflater, container, false)
//
//        binding.lifecycleOwner = viewLifecycleOwner
//
//
//        binding.recyclerProfileItem.adapter = adapter
//        UserManager.myDate.observe(viewLifecycleOwner, Observer {
//
//            when (homeType) {
//                HomeTypeFilter.NEW_RELEASE -> {
//                    adapter.submitList(it.filter { date ->
//                        date.active == true
//                    })
//                }
//                else -> {
//                    adapter.submitList(it.filter { date ->
//                        date.active == false
//                    })
//                }
//            }
//        })
//
        return binding.root
    }


}