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

    val randomValueForWords = returnRandomNumberWord()
    fun setupWordsAndAnswers() {

        binding.tvMainWord.text = questions[randomValueForWords].englishWord
        binding.tvFirstVariantAnswer.text = questions[randomValueForWords].answers[0]
        binding.tvTwosVariantAnswer.text = questions[randomValueForWords].answers[1]
        binding.tvThirdVariantAnswer.text = questions[randomValueForWords].answers[2]
        binding.tvFourVariantAnswer.text = questions[randomValueForWords].answers[3]
    }

    fun chooseRightAnswer() {
        val firstTvValue = binding.tvFirstVariantAnswer.text.toString()
        val twoTvValue = binding.tvTwosVariantAnswer.text.toString()
        val thirdTvValue = binding.tvThirdVariantAnswer.text.toString()
        val fourTvValue = binding.tvFourVariantAnswer.text.toString()
        val correctAnswerIndex = questions[randomValueForWords].correctAnswerIndex
        val correctAnswer = questions[randomValueForWords].answers[correctAnswerIndex]
        when (correctAnswer) {
            firstTvValue -> makeCorrectAnswer()
            twoTvValue -> makeCorrectAnswer()
            thirdTvValue -> makeCorrectAnswer()
            fourTvValue -> makeCorrectAnswer()
            else -> finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnWordBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupWordsAndAnswers()
        binding.lcFirstcontainer.setOnClickListener {
            chooseRightAnswer()
        }
        binding.lcTwoscontainer.setOnClickListener {
            chooseRightAnswer()
        }
        binding.lcThirdcontainer.setOnClickListener {
            chooseRightAnswer()
        }
        binding.lcFourcontainer.setOnClickListener {
            chooseRightAnswer()
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



