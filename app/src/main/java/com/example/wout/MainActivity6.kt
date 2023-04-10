package com.example.wout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wout.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {
    private var binding:ActivityMain6Binding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        setContentView(R.layout.activity_main6)
        binding?.frame111?.setOnClickListener{
            startActivity(Intent(this@MainActivity6,MainActivity2::class.java))
        }
    }
}