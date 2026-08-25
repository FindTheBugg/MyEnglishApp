package com.example.englishapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.englishapp.databinding.ActivityLearnWordBinding
import com.example.myenglishapp.questions
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnWordBinding
    fun returnRandomNumberWord(): Int {
        return Random.nextInt(0,9)
    }
    fun setupWordsAndAnswers() {
        val randomValueForWords = returnRandomNumberWord()
        binding.tvMainWord.text = questions[randomValueForWords].englishWord
        binding.tvFirstVariantAnswer.text = questions[randomValueForWords].answers[0]
        binding.tvTwosVariantAnswer.text = questions[randomValueForWords].answers[1]
        binding.tvThirdVariantAnswer.text = questions[randomValueForWords].answers[2]
        binding.tvFourVariantAnswer.text = questions[randomValueForWords].answers[3]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnWordBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupWordsAndAnswers()
        binding.lcFirstcontainer.setOnClickListener {
            makeCorrectAnswer()
        }
        binding.btExitButton.setOnClickListener {
            finish()
        }
        binding.skipButton.setOnClickListener {
            returnRandomNumberWord()
            setupWordsAndAnswers()
        }
        binding.continueButton.setOnClickListener {
            returnDefaultConditionElements()
            returnRandomNumberWord()
            setupWordsAndAnswers()
        }
    }

    private fun returnDefaultConditionElements() {

        with(binding) {

            for (layout in listOf(
                lcFirstcontainer,
                lcTwoscontainer,
                lcThirdcontainer,
                lcFourcontainer)) {
                layout.background = ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.shape_rounded_containers
                )
            }
            for (layout in listOf(
                tvFirstNumberAnswer,
                tvTwosNumberAnswer,
                tvThirdNumberAnswer,
                tvFourNumberAnswer)) {
                layout.background = ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.shape_rounded_variants
                )
            }
            for (textView in listOf(
                tvFirstVariantAnswer,
                tvTwosVariantAnswer,
                tvThirdVariantAnswer,
                tvFourVariantAnswer)) {
                textView.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.DefaultColorText
                    )
                )
            }

            for (textView in listOf(
                tvFirstNumberAnswer,
                tvTwosNumberAnswer,
                tvThirdNumberAnswer,
                tvFourNumberAnswer)) {
                textView.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.DefaultColorText
                    )
                )
            }

        }
        binding.correctAnswerContainer.isVisible = false
    }


    private fun makeCorrectAnswer() {
        binding.lcFirstcontainer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.succes_shape_rounded_containers
        )
        binding.tvFirstNumberAnswer.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.succes_shape_rounded_variants
        )
        binding.tvFirstNumberAnswer.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )
        binding.tvFirstVariantAnswer.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswer
            )
        )
        binding.correctAnswerContainer.isVisible = true
    }
}



