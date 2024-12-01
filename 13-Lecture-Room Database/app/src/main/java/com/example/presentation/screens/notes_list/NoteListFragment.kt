package com.example.presentation.screens.notes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.databinding.FragmentNotesListBinding
import kotlinx.coroutines.launch

class NoteListFragment : Fragment() {

    private lateinit var binding: FragmentNotesListBinding
    private val viewModel by viewModels<NoteListViewModel>()
    private val noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNotesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setListeners()
        setCollectors()

    }

    // Set Listeners
    private fun setListeners() {
        binding.addNoteButton.setOnClickListener {
            findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToAddNoteFragment())
        }
    }

    // Init Recycler
    private fun initViews() {
        binding.notesRecyclerView.adapter = noteAdapter
    }

    // set collectors
    private fun setCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.notesFlow.collect {
                noteAdapter.submitList(it)
            }
        }
    }
}