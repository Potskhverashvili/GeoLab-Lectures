package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragments.databinding.FragmentSendMessageBinding

class SendMessageFragment : Fragment() {

    private lateinit var binding: FragmentSendMessageBinding

    // ------------------ onCreateView --------------------
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSendMessageBinding.inflate(inflater, container, false)
        return binding.root
    }


    // ----------------- onViewCreated ---------------------
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendButton.setOnClickListener {

            findNavController().navigate(
                SendMessageFragmentDirections.toHomeFragment(
                   message = binding.messageEditText.text.toString()
                )
            )
        }
    }
}