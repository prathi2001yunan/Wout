package com.example.wout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  var binding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        binding?.fram1?.setOnClickListener{
            startActivity(Intent(this,MainActivity2::class.java))
        }
        binding?.button?.setOnClickListener{
            startActivity(Intent(this,MainActivity3::class.java))
        }


    }
}