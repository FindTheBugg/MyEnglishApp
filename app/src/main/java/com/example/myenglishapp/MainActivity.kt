package com.example.englishapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.englishapp.databinding.ActivityLearnWordBinding
import com.example.myenglishapp.UpdateUI
import com.example.myenglishapp.questions
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLearnWordBinding
    private lateinit var updateUI: UpdateUI
    fun returnRandomNumberWord(): Int {
        return Random.nextInt(questions.size)
    }
    private var randomValueForWords = returnRandomNumberWord()
    fun setupWordsAndAnswers() {

        val question = questions[randomValueForWords]

        binding.tvMainWord.text = questions[randomValueForWords].englishWord

        binding.tvFirstVariantAnswer.text = questions[randomValueForWords].answers[0]
        binding.tvTwosVariantAnswer.text = questions[randomValueForWords].answers[1]
        binding.tvThirdVariantAnswer.text = questions[randomValueForWords].answers[2]
        binding.tvFourVariantAnswer.text = questions[randomValueForWords].answers[3]
    }

    private fun showNextQuestion() {
        randomValueForWords = returnRandomNumberWord()
        updateUI.returnDefaultConditionElements()
        setupWordsAndAnswers()
    }

    fun chooseRightAnswer(selectedAnswerIndex: Int) {
        questions[randomValueForWords].correctAnswerIndex

        val correctAnswerIndex =
            questions[randomValueForWords].correctAnswerIndex

        if (selectedAnswerIndex == correctAnswerIndex) {
            updateUI.makeCorrectAnswer(selectedAnswerIndex)
        } else {
            updateUI.makeWrongAnswer(correctAnswerIndex, selectedAnswerIndex)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLearnWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateUI = UpdateUI(
            this,
            binding
        )
        setupWordsAndAnswers()
        binding.lcFirstcontainer.setOnClickListener {
            chooseRightAnswer(0)
        }
        binding.lcTwoscontainer.setOnClickListener {
            chooseRightAnswer(1)
        }
        binding.lcThirdcontainer.setOnClickListener {
            chooseRightAnswer(2)
        }
        binding.lcFourcontainer.setOnClickListener {
            chooseRightAnswer(3)
        }
        binding.btExitButton.setOnClickListener {
            finish()
        }
        binding.skipButton.setOnClickListener {
            showNextQuestion()
        }
        binding.continueButton.setOnClickListener {
            showNextQuestion()
        }
        binding.wrongContinueButton.setOnClickListener {
            showNextQuestion()
        }
    }
}





