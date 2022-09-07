package com.galleryapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.galleryapp.adapter.PixabayAdapter
import com.galleryapp.databinding.FragmentColorsBinding
import com.galleryapp.repository.PixabayRepository
import com.galleryapp.ui.PixabayViewModel
import com.galleryapp.ui.PixabayViewModelProviderFactory


class ColorsFragment : Fragment(), PixabayAdapter.OnImageClickListener  {

    lateinit var pixabayViewModel: PixabayViewModel
    lateinit var colorAdapter: PixabayAdapter
    private lateinit var binding : FragmentColorsBinding
    private val args : ColorsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentColorsBinding.inflate(layoutInflater)
        setupRecyclerView(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val color = args.color
        super.onViewCreated(view, savedInstanceState)
        val pixabayRepository = PixabayRepository()
        pixabayViewModel = ViewModelProvider(this, PixabayViewModelProviderFactory(pixabayRepository,"",color))[PixabayViewModel::class.java]
        pixabayViewModel.colorImages.observe(viewLifecycleOwner, Observer {
            Log.i("PRIYAN", "onViewCreated: $it")
            colorAdapter.setData(it.hits)
        })
    }
    private fun setupRecyclerView(colorsFragment: ColorsFragment) {
        colorAdapter = PixabayAdapter(colorsFragment)
        binding.rvColor.apply {
            adapter = colorAdapter
            layoutManager = GridLayoutManager(activity,2)

        }
    }

    override fun onImageClick(link: String) {
    }
}