package com.example.chatapp.presentation.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.data.Message
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ChatViewModels : ViewModel() {

    private val firebaseDatabase = FirebaseDatabase
        .getInstance("https://chatapp-d7d86-default-rtdb.europe-west1.firebasedatabase.app/")
        .getReference("messages")

    val messagesFlow = MutableStateFlow<List<Message>>(emptyList())

    init {
        firebaseDatabase.addChildEventListener(object : ChildEventListener {
            val messagesList = mutableListOf<Message>()
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val message = snapshot.getValue(Message::class.java)
                if (message != null) {
                    messagesList.add(message)
                }

                viewModelScope.launch {
                    messagesFlow.emit(messagesList.reversed())
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) = Unit
            override fun onChildRemoved(snapshot: DataSnapshot) = Unit
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) = Unit
            override fun onCancelled(error: DatabaseError) = Unit
        })
    }

    fun sendMessage(message: Message) {
        firebaseDatabase
            .child(message.id.toString())
            .setValue(message)
            .addOnSuccessListener { }
            .addOnFailureListener { }
    }

}