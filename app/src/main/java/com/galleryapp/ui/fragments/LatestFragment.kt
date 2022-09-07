package com.galleryapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.galleryapp.adapter.PixabayAdapter
import com.galleryapp.databinding.FragmentLatestBinding
import com.galleryapp.repository.PixabayRepository
import com.galleryapp.ui.PixabayViewModel
import com.galleryapp.ui.PixabayViewModelProviderFactory


class LatestFragment : Fragment() , PixabayAdapter.OnImageClickListener {

    lateinit var pixabayViewModel: PixabayViewModel
    lateinit var latestAdapter: PixabayAdapter
    private lateinit var binding : FragmentLatestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLatestBinding.inflate(layoutInflater)
        setupRecyclerView(this)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pixabayRepository = PixabayRepository()
        pixabayViewModel = ViewModelProvider(this, PixabayViewModelProviderFactory(pixabayRepository,"",""))[PixabayViewModel::class.java]
        pixabayViewModel.latestImages.observe(viewLifecycleOwner, Observer {
            Log.i("PRIYAN", "onViewCreated: $it")
            latestAdapter.setData(it.hits)
        })
    }
    private fun setupRecyclerView(latestFragment: LatestFragment) {
        latestAdapter = PixabayAdapter(latestFragment)
        binding.rvLatest.apply {
            adapter = latestAdapter
            layoutManager = GridLayoutManager(activity,2)

        }
    }

    override fun onImageClick(link: String) {
    }
}