package com.example.chatapp.presentation.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.chatapp.data.Message
import com.example.chatapp.databinding.FragmentChatBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import java.util.UUID

class ChatFragment : Fragment() {

    private val viewModel by viewModels<ChatViewModels>()
    private lateinit var binding: FragmentChatBinding
    private val messageAdapter = MessageAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        setListeners()
        setCollectors()

    }

    // recycler view init
    private fun initRecyclerView() {
        binding.messagesRecyclerView.adapter = messageAdapter
    }

    // set listeners
    private fun setListeners() = with(binding) {
        binding.sendButton.setOnClickListener {
            viewModel.sendMessage(
                Message(
                    id = UUID.randomUUID().toString(),
                    text = messageEditText.text.toString(),
                    senderEmail = FirebaseAuth.getInstance().currentUser?.email

                )
            )
            messageEditText.text.clear()
        }
    }

    //
    private fun setCollectors() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.messagesFlow.collect {
                messageAdapter.setMessages(it)
            }
        }
    }

}