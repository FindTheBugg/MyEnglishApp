package com.example.myenglishapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.englishapp.R
import com.example.englishapp.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater)
        val view = inflater.inflate(
            R.layout.fragment_start,
            container,
            false)
        binding.startButton.setOnClickListener {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, LearnFragment())
            .addToBackStack(null)
            .commit()
        }
        return binding.root
    }

}