package com.example.wout

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.wout.databinding.ActivityMain2Binding
import com.example.wout.databinding.ActivityMain4Binding
import java.util.Objects

class MainActivity4 : AppCompatActivity() {
    private  var binding: ActivityMain4Binding?=null
    private  var timer: CountDownTimer?=null
    private var l1:String?=null
    var result1: Int = 0
    var char1:String="false"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        val intent1 = intent.getParcelableExtra<List1>("list1")
        binding?.textView2?.text = intent1?.tx1
        binding?.textView3?.text = "${intent1?.tx2}"
        l1= "${intent1?.tx2}"
        intent1?.img?.let { binding?.imageView2?.setImageResource(it) }
        Tim1()

        }

        private fun Tim1() {
            binding?.progress1?.progress = result1
            timer = object : CountDownTimer(10000, 1000) {
                override fun onTick(res: Long) {
                    result1++
                    binding?.progress1?.progress = 10 - result1
                    binding?.tvn?.text = (10 - result1).toString()

                }

                override fun onFinish() {

                    binding?.fram3?.visibility=View.GONE
                    binding?.fram4?.visibility=View.VISIBLE


                    binding?.fram4?.setOnClickListener {
                        val nam1= l1
                            val Intent = Intent(this@MainActivity4,MainActivity5::class.java)
                        Intent.putExtra("Nam",nam1)
                        startActivity(Intent)


                    }



                }

            }.start()
        }


    override fun onDestroy() {
        super.onDestroy()
        if(timer!=null){
            timer?.cancel()
        }
        binding=null
    }
}