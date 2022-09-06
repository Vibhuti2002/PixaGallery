package com.galleryapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.galleryapp.R
import com.galleryapp.databinding.FragmentHomeBinding


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
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        binding.cvNature.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoriesFragment)
        }
        binding.cvBackground.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoriesFragment)
        }
        binding.cvAnimals.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoriesFragment)
        }
        binding.cvReligion.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_categoriesFragment)
        }
        return binding.root
    }

}