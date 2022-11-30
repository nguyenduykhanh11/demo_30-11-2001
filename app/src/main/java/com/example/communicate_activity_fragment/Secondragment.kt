package com.example.communicate_activity_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.communicate_activity_fragment.databinding.FragmentSecondragmentBinding

class Secondragment : Fragment() {
    private lateinit var binding: FragmentSecondragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromFirstFragment()
    }

    private fun getDataFromFirstFragment() {
        val data = arguments?.getString(FRAGMENT_TO_FRAGMENT)
        binding.tvResultSecondFragment.setText(data)
    }

}