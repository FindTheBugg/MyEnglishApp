package com.example.englishapp

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.englishapp.R
import com.example.englishapp.databinding.ActivityLearnWordBinding


class UpdateUI(
    var context: Context,
    var binding: ActivityLearnWordBinding
) {

    fun blockAnswer() {
        binding.lcFirstcontainer.isClickable = false
        binding.lcTwoscontainer.isClickable = false
        binding.lcThirdcontainer.isClickable = false
        binding.lcFourcontainer.isClickable = false
    }

    fun unLockAnswer() {
        binding.lcFirstcontainer.isClickable = true
        binding.lcTwoscontainer.isClickable = true
        binding.lcThirdcontainer.isClickable = true
        binding.lcFourcontainer.isClickable = true
    }

    fun returnDefaultConditionElements() {

        with(binding) {

            for (layout in listOf(
                lcFirstcontainer,
                lcTwoscontainer,
                lcThirdcontainer,
                lcFourcontainer
            )) {
                layout.background = ContextCompat.getDrawable(
                    context,
                    R.drawable.shape_rounded_containers
                )
            }
            for (layout in listOf(
                tvFirstNumberAnswer,
                tvTwosNumberAnswer,
                tvThirdNumberAnswer,
                tvFourNumberAnswer
            )) {
                layout.background = ContextCompat.getDrawable(
                    context,
                    R.drawable.shape_rounded_variants
                )
            }
            for (textView in listOf(
                tvFirstVariantAnswer,
                tvTwosVariantAnswer,
                tvThirdVariantAnswer,
                tvFourVariantAnswer
            )) {
                textView.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.DefaultColorText
                    )
                )
            }

            for (textView in listOf(
                tvFirstNumberAnswer,
                tvTwosNumberAnswer,
                tvThirdNumberAnswer,
                tvFourNumberAnswer
            )) {
                textView.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.DefaultColorText
                    )
                )
            }

        }
        binding.correctAnswerContainer.isVisible = false
        binding.wrongContainer.isVisible = false
        unLockAnswer()
    }

    fun makeCorrectAnswer(correctIndex: Int) {

        val correctContainers = listOf(
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

        val container = correctContainers[correctIndex]
        val textViewNumber = textViewsNumbers[correctIndex]

        container.background = ContextCompat.getDrawable(
            context,
            R.drawable.succes_shape_rounded_containers
        )
        textViewNumber.background = ContextCompat.getDrawable(
            context,
            R.drawable.succes_shape_rounded_variants
        )
        textViewNumber.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.white
            )
        )
        binding.correctAnswerContainer.isVisible = true
        blockAnswer()

    }

    fun makeWrongAnswer(correctIndex: Int, selectedAnswerIndex: Int) {

        val correctContainers = listOf(
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

        val container = correctContainers[correctIndex]
        val textViewNumber = textViewsNumbers[correctIndex]

        container.background = ContextCompat.getDrawable(
            context,
            R.drawable.succes_shape_rounded_containers
        )
        textViewNumber.background = ContextCompat.getDrawable(
            context,
            R.drawable.succes_shape_rounded_variants
        )
        textViewNumber.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.white
            )
        )

        val wrongContainers = listOf(
            binding.lcFirstcontainer,
            binding.lcTwoscontainer,
            binding.lcThirdcontainer,
            binding.lcFourcontainer
        )

        val wrongTextViewsNumbers = listOf(
            binding.tvFirstNumberAnswer,
            binding.tvTwosNumberAnswer,
            binding.tvThirdNumberAnswer,
            binding.tvFourNumberAnswer
        )

        val wrongContainer = wrongContainers[selectedAnswerIndex]
        val wrongTextViewNumber = wrongTextViewsNumbers[selectedAnswerIndex]

        wrongContainer.background = ContextCompat.getDrawable(
            context,
            R.drawable.wrong_shape_rounded_containers
        )
        wrongTextViewNumber.background = ContextCompat.getDrawable(
            context,
            R.drawable.wrong_shape_rounded_variants
        )
        wrongTextViewNumber.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.white
            )
        )
        binding.wrongContainer.isVisible = true
        blockAnswer()
    }
}