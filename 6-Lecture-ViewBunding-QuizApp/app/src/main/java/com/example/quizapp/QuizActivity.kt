package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    // Binding with by lazy
    private val binding by lazy { ActivityQuizBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        d("MyLog", "onCreate")

        refreshQuestion()
        setListener()
    }

    // --------------------------------- Attributes -------------------------------
    private var currentQuestionIndex = 0
    private var score = 0
    private val questionsList = listOf(
        Question(
            question = "საქართველოს დედაქალაქი?",
            options = listOf("თბილისი", "თელავი", "ბათუმი"),
            correctAnswer = "თბილისი"
        ),

        Question(
            question = "გერმანიის დედაქალაქი",
            options = listOf("ბერლინი", "ზუგდიდი", "ჩხოროწყუ"),
            correctAnswer = "ბერლინი"
        ),

        Question(
            question = "ინგლისის დედაქალაქი",
            options = listOf("ლონდონი", "ხაშური", "დელი"),
            correctAnswer = "ლონდონი",
        )
    )

    // ---------------------------------- Helper Functions ----------------------------------

    // refresh questions
    private fun refreshQuestion() {
        d("MyLog", "refreshQuestion")
        val currentQuestion = questionsList[currentQuestionIndex]
        with(binding) {
            val currentQuestions = questionsList[currentQuestionIndex]
            questionTextView.text = currentQuestion.question
            answerButton1.text = currentQuestion.options[0]
            answerButton2.text = currentQuestion.options[1]
            answerButton3.text = currentQuestion.options[2]
        }
    }

    // It sets listeners on the buttons
    private fun setListener() {
        d("MyLog", "setListener")
        with(binding) {
            listOf(answerButton1, answerButton2, answerButton3).forEach { button ->
                button.setOnClickListener {
                    checkAnswer(button.text.toString())
                }
            }
        }
    }


    // check answers
    private fun checkAnswer(answer: String) {
        d("MyLog", "checkAnswer")
        val currentQuestion = questionsList[currentQuestionIndex]
        if (currentQuestion.correctAnswer == answer) {
            score++
        }

        if (currentQuestionIndex != questionsList.lastIndex) {
            currentQuestionIndex++
            refreshQuestion()
        } else {
            val resultActivityIntent = Intent(this, ResultActivity::class.java)
            resultActivityIntent.putExtra("finalScore", score)
            startActivity(resultActivityIntent)
        }
    }
}

// ---------------------------------- Question Class ----------------------------
class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: String,
)