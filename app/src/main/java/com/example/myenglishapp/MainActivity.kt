package com.example.englishapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.englishapp.databinding.ActivityLearnWordBinding
import com.example.myenglishapp.ContentManager
import com.example.myenglishapp.UpdateUI


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityLearnWordBinding
    lateinit var updateUI: UpdateUI

    lateinit var contentManager: ContentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLearnWordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateUI = UpdateUI(
            this,
            binding
        )
        contentManager = ContentManager(
            binding,
//            this,
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
            finish()
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
    }
}





