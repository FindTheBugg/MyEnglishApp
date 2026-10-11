package com.example.myenglishapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.englishapp.databinding.FragmentFavoriteBinding
import com.example.myenglishapp.WordAdapter


class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.d("Lifecycle", "onCreateView")
        val words = listOf("Settings", "Profile", "Theme", "Results", "Exit")
        _binding = FragmentFavoriteBinding.inflate(
            inflater,
            container,
            false
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = WordAdapter(words)

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Lifecycle", "onDestroyView")
        _binding = null
    }
}