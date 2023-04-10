package com.example.wout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wout.databinding.ActivityMain7Binding

class MainActivity7 : AppCompatActivity() {
    private var binding:ActivityMain7Binding?=null
    private var bmi:Double = 0.0
    private var bmi2:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding?.root)

        setContentView(R.layout.activity_main7)
        binding?.button2?.setOnClickListener{
            Toast.makeText(this,"kjjkk",Toast.LENGTH_LONG).show()
        }



    }

}