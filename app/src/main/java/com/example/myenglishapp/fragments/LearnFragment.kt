package com.example.myenglishapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.englishapp.ContentManager
import com.example.englishapp.R
import com.example.englishapp.UpdateUI
import com.example.englishapp.databinding.FragmentLearnBinding



class LearnFragment : Fragment() {
    lateinit var contentManager: ContentManager
    lateinit var binding: FragmentLearnBinding
    lateinit var updateUI: UpdateUI
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLearnBinding.inflate(
            inflater,
            container,
            false
        )
        updateUI = UpdateUI(
            requireContext(),
            binding
        )
        contentManager = ContentManager(
            binding,
            updateUI
        )
        contentManager.setupWordsAndAnswers()
        binding.lcFirstcontainer.setOnClickListener {
            contentManager.chooseRightAnswer(0)
        }
        binding.lcTwoscontainer.setOnClickListener {
            contentManager.chooseRightAnswer(1)
        }
        binding.lcThirdcontainer.setOnClickListener {
            contentManager.chooseRightAnswer(2)
        }
        binding.lcFourcontainer.setOnClickListener {
            contentManager.chooseRightAnswer(3)
        }
        binding.btExitButton.setOnClickListener {
            requireActivity().finish()
        }
        binding.skipButton.setOnClickListener {
            contentManager.showNextQuestion()
        }
        binding.continueButton.setOnClickListener {
            contentManager.showNextQuestion()
        }
        binding.wrongContinueButton.setOnClickListener {
            contentManager.showNextQuestion()
        }
        return binding.root
    }



}