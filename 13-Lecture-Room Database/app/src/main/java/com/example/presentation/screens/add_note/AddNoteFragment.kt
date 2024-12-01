package com.example.presentation.screens.add_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.databinding.FragmentAddNoteBinding
import kotlinx.coroutines.launch


class AddNoteFragment : Fragment() {
    // binding
    private lateinit var binding: FragmentAddNoteBinding

    // view model
    private val viewModel by viewModels<AddNotesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setCollectors()
    }

    //set collectors
    private fun setCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.noteSavedFlow.collect {
                findNavController().navigateUp()
            }
        }
    }

    // set listeners
    private fun setListeners() = with(binding) {
        createNoteButton.setOnClickListener {
            viewModel.saveNote(
                title = titleEditText.text.toString(),
                description = descriptionEditText.text.toString()
            )
        }
    }
}