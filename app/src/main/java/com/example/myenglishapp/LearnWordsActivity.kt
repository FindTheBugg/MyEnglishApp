package com.example.englishapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.englishapp.databinding.ActivityLearnWordBinding
import com.example.myenglishapp.fragments.StartFragment


class LearnWordsActivity : AppCompatActivity() {

    lateinit var binding: ActivityLearnWordBinding

//    lateinit var contentManager: ContentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLearnWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, StartFragment())
            .commit()


    }
}





