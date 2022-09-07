package com.galleryapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.galleryapp.adapter.PixabayAdapter
import com.galleryapp.databinding.FragmentCategoriesBinding
import com.galleryapp.repository.PixabayRepository
import com.galleryapp.ui.PixabayViewModel
import com.galleryapp.ui.PixabayViewModelProviderFactory
import androidx.navigation.fragment.navArgs


class CategoriesFragment : Fragment(), PixabayAdapter.OnImageClickListener {
    lateinit var pixabayViewModel: PixabayViewModel
    lateinit var categoriesAdapter: PixabayAdapter
    private lateinit var binding: FragmentCategoriesBinding
    private val args : CategoriesFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        val category = args.category
        setupRecyclerView(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val category = args.category
        binding.tvHead.text = category.uppercase()
        val pixabayRepository = PixabayRepository()
        pixabayViewModel = ViewModelProvider(this, PixabayViewModelProviderFactory(pixabayRepository,category, ""))[PixabayViewModel::class.java]

        pixabayViewModel.categoryImages.observe(viewLifecycleOwner, Observer {
            Log.i("PRIYAN", "onViewCreated: $it")
            categoriesAdapter.setData(it.hits)
        })

        /*pixabayViewModel.latestImages.observe(viewLifecycleOwner, Observer {
            Log.i("PRIYAN", "onViewCreated: $it")
            categoriesAdapter.setData(it.hits)
        })*/
    }

    private fun setupRecyclerView(categoriesFragment: CategoriesFragment) {
        categoriesAdapter = PixabayAdapter(categoriesFragment)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvCategories.apply {
            adapter = categoriesAdapter
            layoutManager = GridLayoutManager(activity,2)
            //layoutManager = staggeredGridLayoutManager

        }
    }

    override fun onImageClick(link: String) {
        val action = CategoriesFragmentDirections.actionCategoriesFragmentToFullImageFragment(link)
        findNavController().navigate(action)
    }


}