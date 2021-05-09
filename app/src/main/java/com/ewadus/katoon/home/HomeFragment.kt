package com.ewadus.katoon.home

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ewadus.katoon.R
import com.ewadus.katoon.VdoGridAdapter
import com.ewadus.katoon.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.vdoGrid.adapter = VdoGridAdapter()

       binding.pullRefresh.setOnRefreshListener {
           viewModel.pull2Refresh()
           binding.pullRefresh.isRefreshing = false

       }



        return binding.root
    }


}