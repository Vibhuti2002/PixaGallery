package com.galleryapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.galleryapp.adapter.CategoriesAdapter
import com.galleryapp.databinding.FragmentCategoriesBinding
import com.galleryapp.model.Hit
import com.galleryapp.repository.PixabayRepository
import com.galleryapp.ui.PixabayViewModel
import com.galleryapp.ui.PixabayViewModelProviderFactory


class CategoriesFragment : Fragment() {
    lateinit var pixabayViewModel: PixabayViewModel
    lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var binding: FragmentCategoriesBinding
    private val categoriesData = ArrayList<List<Hit>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pixabayRepository = PixabayRepository()
        pixabayViewModel = ViewModelProvider(this, PixabayViewModelProviderFactory(pixabayRepository))[PixabayViewModel::class.java]


        pixabayViewModel.latestImages.observe(viewLifecycleOwner, Observer {
            Log.i("PRIYAN", "onViewCreated: $it")
            categoriesAdapter.setData(it.hits)
        })
    }

    private fun setupRecyclerView(){
        categoriesAdapter = CategoriesAdapter()
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvCategories.apply {
            adapter = categoriesAdapter
            layoutManager = staggeredGridLayoutManager

        }
    }

}