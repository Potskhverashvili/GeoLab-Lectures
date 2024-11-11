package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemUserBinding


class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = users[position]
        holder.binding.usernameTextView.text = user.username
        holder.binding.ageTextView.text = user.age.toString()
        holder.binding.hobbiesTextView.text = user.hobbies

    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = users.size



    // ViewHolder class
    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

}