package com.example.englishapp


import com.example.englishapp.databinding.FragmentLearnBinding
import com.example.myenglishapp.fragments.LearnFragment
import kotlin.random.Random


class ContentManager(
     var binding: FragmentLearnBinding,
     var updateUI: UpdateUI,
) {

    var progress = binding.progressBar.progress


    fun updateProgress() {
        progress++
        binding.progressBar.progress = progress
    }

    var randomValueForWords = returnRandomNumberWord()
    private val currentQuestion
        get() = questions[randomValueForWords]
    fun showNextQuestion() {

        randomValueForWords = returnRandomNumberWord()
        updateUI.returnDefaultConditionElements()
        setupWordsAndAnswers()
    }
    fun returnRandomNumberWord(): Int {
        return Random.nextInt(questions.size)
    }

    fun setupWordsAndAnswers() {

        binding.tvMainWord.text = questions[randomValueForWords].englishWord

        binding.tvFirstVariantAnswer.text = currentQuestion.answers[0]
        binding.tvTwosVariantAnswer.text = currentQuestion.answers[1]
        binding.tvThirdVariantAnswer.text = currentQuestion.answers[2]
        binding.tvFourVariantAnswer.text = currentQuestion.answers[3]
    }

    fun chooseRightAnswer(selectedAnswerIndex: Int) {

        val correctAnswerIndex =
            currentQuestion.correctAnswerIndex

        if (selectedAnswerIndex == correctAnswerIndex) {
            updateProgress()
            updateUI.makeCorrectAnswer(selectedAnswerIndex)
        } else {
            updateUI.makeWrongAnswer(correctAnswerIndex, selectedAnswerIndex)
        }
    }

}