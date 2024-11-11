package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    private val users = listOf(
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar"),
        User("user1", 21, "guitar")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.usersRecyclerView.adapter = UserAdapter(users)
    }
}
