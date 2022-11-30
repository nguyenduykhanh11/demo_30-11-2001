package com.example.dialog_alertdialog

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialog_alertdialog.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var builderAlert: AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        builderAlert = AlertDialog.Builder(this)
        setUpListenerClickAlertDialog()
        setUpListenerClickToListGirtView()
    }

    private fun setUpListenerClickToListGirtView() {
        binding.btnListGirtView.setOnClickListener {
            val intent = Intent(this, ListGirdViewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpListenerClickAlertDialog() {
        binding.btnDialog.setOnClickListener {
            builderAlert.setTitle("Demo AlertDiaLog")
                .setMessage("Alert đã học chưa")
                .setPositiveButton("Rồi"){view, it->
                    Toast.makeText(applicationContext, "Rồi", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Chưa"){view, it ->
                    Toast.makeText(applicationContext, "Chưa", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Giúp"){view, it->
                    Toast.makeText(applicationContext, "Giúp", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}