package com.example.communicate_activity_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.communicate_activity_fragment.databinding.ActivityMainBinding
import com.example.communicate_activity_fragment.viewModel.SendDataViewModel
import androidx.fragment.app.Fragment as Fragment

const val ACTIVYTY_TO_ACTIVITY = "ACTIVYTY_TO_ACTIVITY"
const val ACTIVYTY_TO_FRAGMENT = "ACTIVYTY_TO_FRAGMENT"
const val FRAGMENT_TO_FRAGMENT = "FRAGMENT_TO_FRAGMENT"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: SendDataViewModel by viewModels()
    private var data:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sendDataToSecondActivity()
        sendDatatoFirstFragment()

        getDataFromFirstFragment()
    }

    private fun getDataFromFirstFragment() {
        viewModel.selectedData.observe(this){data->
            binding.edtData.setText(data)
        }
    }

    private fun sendDatatoFirstFragment() {
        binding.flaotToFragment.setOnClickListener {
            data = binding.edtData.text.toString()
            binding.edtData.setText("")
            showFragment(FirstFragment(), ACTIVYTY_TO_FRAGMENT, data)
        }
    }

    private fun sendDataToSecondActivity() {
        with(binding){
            flaotToActivity.setOnClickListener {
                data = binding.edtData.text.toString()
                val intern = Intent(this@MainActivity, SecondActivity::class.java)
                intern.putExtra(ACTIVYTY_TO_ACTIVITY, data)
                binding.edtData.setText("")
                startActivity(intern)
            }
        }
    }
    fun showFragment(fragment: Fragment, key: String, data: String?) {
        val bundle = Bundle()
        bundle.putString(key, data)
        supportFragmentManager.beginTransaction().apply {
            fragment.arguments = bundle
            replace(R.id.fragment,fragment)
            addToBackStack(null)
            commit()
        }
    }
}