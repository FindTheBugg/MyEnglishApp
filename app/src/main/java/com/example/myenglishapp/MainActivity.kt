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
        returnDefaultConditionElements()
        setupWordsAndAnswers()
    }

    fun chooseRightAnswer(selectedAnswerIndex: Int) {
        questions[randomValueForWords].correctAnswerIndex

        val correctAnswerIndex =
            questions[randomValueForWords].correctAnswerIndex

        if (selectedAnswerIndex == correctAnswerIndex) {
            makeCorrectAnswer(selectedAnswerIndex)
        } else {
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnWordBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
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


    private fun makeCorrectAnswer(index: Int) {

        val containers = listOf(
            binding.lcFirstcontainer,
            binding.lcTwoscontainer,
            binding.lcThirdcontainer,
            binding.lcFourcontainer
        )

        val textViewsNumbers = listOf(
            binding.tvFirstNumberAnswer,
            binding.tvTwosNumberAnswer,
            binding.tvThirdNumberAnswer,
            binding.tvFourNumberAnswer
        )

        val textViewsAnswers = listOf(
            binding.tvFirstVariantAnswer,
            binding.tvTwosVariantAnswer,
            binding.tvThirdVariantAnswer,
            binding.tvFourVariantAnswer
        )

        val container = containers[index]
        val textviewAnswer = textViewsNumbers[index]
        val textViewNumber = textViewsNumbers[index]

        container.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.succes_shape_rounded_containers
        )
        textViewNumber.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.succes_shape_rounded_variants
        )
        textViewNumber.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )
        binding.correctAnswerContainer.isVisible = true
        }

    





    }





