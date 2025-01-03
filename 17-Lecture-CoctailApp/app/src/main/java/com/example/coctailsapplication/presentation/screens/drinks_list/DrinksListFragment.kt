package com.example.coctailsapplication.presentation.screens.drinks_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.coctailsapplication.databinding.FragmentDrinksListBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DrinksListFragment : Fragment() {

    private val viewModel by viewModel<DrinksListViewModel>()
    private lateinit var binding: FragmentDrinksListBinding
    private val drinksAdapter = DrinkAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentDrinksListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setCollectors()
    }

    private fun initViews() {
        binding.drinksRecyclerView.adapter = drinksAdapter
    }

    private fun setCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.drinksFlow.collect {
                drinksAdapter.submitList(it)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.errorFlow.collect {
                Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}