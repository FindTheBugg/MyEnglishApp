package com.example.englishapp

import com.example.englishapp.databinding.ActivityLearnWordBinding
import kotlin.random.Random


class ContentManager(
    var binding: ActivityLearnWordBinding,
     var updateUI: UpdateUI
) {


    fun showNextQuestion() {
        randomValueForWords = returnRandomNumberWord()
        updateUI.returnDefaultConditionElements()
        setupWordsAndAnswers()
    }
    fun returnRandomNumberWord(): Int {
        return Random.nextInt(questions.size)
    }
    var randomValueForWords = returnRandomNumberWord()
    fun setupWordsAndAnswers() {

        binding.tvMainWord.text = questions[randomValueForWords].englishWord

        binding.tvFirstVariantAnswer.text = questions[randomValueForWords].answers[0]
        binding.tvTwosVariantAnswer.text = questions[randomValueForWords].answers[1]
        binding.tvThirdVariantAnswer.text = questions[randomValueForWords].answers[2]
        binding.tvFourVariantAnswer.text = questions[randomValueForWords].answers[3]
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



}