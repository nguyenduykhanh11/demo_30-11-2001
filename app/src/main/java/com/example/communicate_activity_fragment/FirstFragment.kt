package com.example.communicate_activity_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.communicate_activity_fragment.databinding.FragmentFirstBinding
import com.example.communicate_activity_fragment.viewModel.SendDataViewModel


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: SendDataViewModel by activityViewModels()
    private var data:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromMainActivity()
        setUpSendDataToActivity()
        sendDatatoFragment()
    }

    private fun sendDatatoFragment() {
        binding.flaotToFragment.setOnClickListener {
            data = binding.edtData.text.toString()
            (activity as MainActivity).showFragment(Secondragment(), FRAGMENT_TO_FRAGMENT, data)
        }
    }

    private fun getDataFromMainActivity() {
        binding.edtData.setText(arguments?.getString(ACTIVYTY_TO_FRAGMENT))
    }

    private fun setUpSendDataToActivity() {
        binding.flaotToActivityFragment.setOnClickListener {
            data = binding.edtData.text.toString()
            viewModel.selectData(data!!)
            binding.edtData.setText(null)
        }
    }
}