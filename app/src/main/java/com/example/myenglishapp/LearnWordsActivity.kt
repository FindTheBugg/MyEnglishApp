package com.example.englishapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.englishapp.databinding.ActivityLearnWordBinding
import com.example.myenglishapp.fragments.StartFragment


class LearnWordsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_learn_word)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, StartFragment())
            .commit()



    }
}





