package com.galleryapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.galleryapp.R
import com.galleryapp.databinding.FragmentFullImageBinding

class FullImageFragment : Fragment() {

    private lateinit var binding: FragmentFullImageBinding
    private val args : FullImageFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val link = args.link
        binding = FragmentFullImageBinding.inflate(layoutInflater)
        Glide.with(requireContext()).load(link).into(binding.ivFullImg)
        return binding.root
    }
}