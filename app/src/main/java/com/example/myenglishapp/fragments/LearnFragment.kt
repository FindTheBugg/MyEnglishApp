package com.example.myenglishapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.englishapp.ContentManager
import com.example.englishapp.R
import com.example.englishapp.UpdateUI
import com.example.englishapp.databinding.FragmentLearnBinding



class LearnFragment : Fragment() {
    private var _binding: FragmentLearnBinding? = null
    private val binding get() = _binding!!
    private lateinit var updateUI: UpdateUI
    private lateinit var contentManager: ContentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.d("Lifecycle", "onCreateView")

        _binding = FragmentLearnBinding.inflate(
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
        binding.favoriteFragmentButton.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, FavoriteFragment())
                .addToBackStack(null)
                .commit()
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Lifecycle", "onDestroyView")
        _binding = null
    }
}