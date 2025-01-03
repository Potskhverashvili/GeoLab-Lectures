package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragments.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val args by navArgs<HomeFragmentArgs>()
    private lateinit var binding: FragmentHomeBinding

    // ------------------- onCreateView --------------
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    // ------------------ onViewCreated ------------------
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.resultTextView.text = args.message

        binding.goBackButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.goToProfile.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToProfileFragment())
        }
    }
}