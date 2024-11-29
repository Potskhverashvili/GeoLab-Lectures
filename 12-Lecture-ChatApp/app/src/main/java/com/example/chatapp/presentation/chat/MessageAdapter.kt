package com.example.chatapp.presentation.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.data.Message
import com.example.chatapp.databinding.ItemMessageReceivedBinding
import com.example.chatapp.databinding.ItemMessageSentBinding
import com.google.firebase.auth.FirebaseAuth

class MessageAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // property
    private var messages = emptyList<Message>()

    // set method
    fun setMessages(newMessages: List<Message>) {
        messages = newMessages
        notifyDataSetChanged()
    }

    // -------------------------------- Override Methods ----------------------------------
    override fun getItemViewType(position: Int): Int {
        val message = messages[position]
        return if (message.senderEmail == FirebaseAuth.getInstance().currentUser?.email) {
            SENT_MESSAGE_TYPE
        } else {
            RECEIVED_MESSAGE_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == SENT_MESSAGE_TYPE) {
            SentMessageViewHolder(
                ItemMessageSentBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {

            ReceivedMessageViewHolder(
                ItemMessageReceivedBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    }

    override fun getItemCount() = messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SentMessageViewHolder -> holder.bind(messages[position])
            is ReceivedMessageViewHolder -> holder.bind(messages[position])
        }
    }

    // -------------------------------- View Holders ----------------------------
    class ReceivedMessageViewHolder(private val binding: ItemMessageReceivedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.emailTextView.text = message.senderEmail
            binding.messageTextView.text = message.text
        }
    }

    class SentMessageViewHolder(private val binding: ItemMessageSentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.emailTextView.text = message.senderEmail
            binding.messageTextView.text = message.text
        }
    }


    // companion object
    companion object {
        const val SENT_MESSAGE_TYPE = 1
        const val RECEIVED_MESSAGE_TYPE = 2
    }

}