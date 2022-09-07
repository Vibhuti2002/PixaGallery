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
import com.galleryapp.R
import com.galleryapp.adapter.PixabayAdapter
import com.galleryapp.databinding.FragmentHomeBinding
import com.galleryapp.repository.PixabayRepository
import com.galleryapp.ui.PixabayViewModel
import com.galleryapp.ui.PixabayViewModelProviderFactory


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //colors
        binding.viewOrange.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToColorsFragment("orange")
            findNavController().navigate(action)
        }

        binding.viewYellow.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToColorsFragment("yellow")
            findNavController().navigate(action)
        }

        binding.viewGreen.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToColorsFragment("green")
            findNavController().navigate(action)
        }

        binding.viewCyan.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToColorsFragment("turquoise")
            findNavController().navigate(action)
        }

        binding.viewBlue.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToColorsFragment("blue")
            findNavController().navigate(action)
        }

        binding.viewRed.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToColorsFragment("red")
            findNavController().navigate(action)
        }

        //categories
        binding.cvNature.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCategoriesFragment("nature")
            findNavController().navigate(action)
        }
        binding.cvBackground.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCategoriesFragment("backgrounds")
            findNavController().navigate(action)
        }
        binding.cvAnimals.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCategoriesFragment("animals")
            findNavController().navigate(action)
        }
        binding.cvReligion.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCategoriesFragment("religion")
            findNavController().navigate(action)
        }
        binding.cvPlaces.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCategoriesFragment("places")
            findNavController().navigate(action)
        }
        binding.cvFood.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCategoriesFragment("food")
            findNavController().navigate(action)
        }

        //exploreAll
        binding.btnExplore.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToLatestFragment()
            findNavController().navigate(action)
        }

    }



}