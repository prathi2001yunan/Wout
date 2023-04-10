package com.example.wout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wout.databinding.ActivityMain2Binding
import com.example.wout.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private  var binding: ActivityMain2Binding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main2)
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        //setContentView(R.layout.activity_main2)
        val list9 = MainAdapter(List2().list5)
        binding?.recycle1?.adapter=list9
        list9.onItemclick={
           val intent = Intent(this,MainActivity4::class.java)
            intent.putExtra("list1",it)
            startActivity(intent)
        }

    }
}