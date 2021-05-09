package com.ewadus.katoon.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ewadus.katoon.R
import com.ewadus.katoon.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )
        binding.lifecycleOwner = this

        val videoModel = DetailFragmentArgs.fromBundle(requireArguments()).selectedVideo
        val viewModelFactory = DetailViewModelFactory(videoModel, application)

        binding.detailViewModel =
            ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        return binding.root
    }


}