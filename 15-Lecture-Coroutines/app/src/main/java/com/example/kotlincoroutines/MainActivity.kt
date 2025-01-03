package com.example.kotlincoroutines

import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var count = 0
    private val myRepository = MyRepository()
    private val usersId = listOf<Long>(244545, 543, 3434, 3242)


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        // ------------------------------------- Async/await ----------------------------

        lifecycleScope.launch {
            val usersList = usersId.map {
                lifecycleScope.async { myRepository.getUserById(it) }
            }

            d("MyLog", usersList.awaitAll().toString())
        }


        // --------------------------- Coroutines in While ------------------------
        lifecycleScope.launch(Dispatchers.Default) {

            // -------- each iteration makes new launch -----------
            while (true) {
                lifecycleScope.launch {
                    val delayValue = Random.nextLong(500, 3000)
                    delay(delayValue)
                    d("MyLog", delayValue.toString())
                }
            }

        }


        // ------------------------------------ SuperJob ----------------------------------
        binding.button.setOnClickListener {
            // SuperJob
            lifecycleScope.launch(Dispatchers.Default + SupervisorJob()) {
                count++

                // With Main Threads
                withContext(Dispatchers.Main) {
                    binding.countTextView.text = count.toString()
                }
            }
        }


        // ------------------------------------- With Context ---------------------------------
        binding.button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                count++

                // With Main Threads
                withContext(Dispatchers.Main) {
                    binding.countTextView.text = count.toString()
                }
            }
        }
    }
}


class MyRepository {
    suspend fun getUserById(userId: Long): UserEntity {
        delay(3000) // Job Simulation
        return UserEntity()
    }
}

data class UserEntity(
    val id: Long = 0,
    val name: String = "user",
)
