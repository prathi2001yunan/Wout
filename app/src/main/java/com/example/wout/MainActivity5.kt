package com.example.wout

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.wout.databinding.ActivityMain2Binding
import com.example.wout.databinding.ActivityMain4Binding
import com.example.wout.databinding.ActivityMain5Binding
import com.example.wout.databinding.CustomdialogBinding
import java.util.*
import kotlin.collections.ArrayList

 class MainActivity5 : AppCompatActivity(), TextToSpeech.OnInitListener {
    private var binding: ActivityMain5Binding? = null


    private var binding2: ActivityMain2Binding?=null
    private var speak1k:TextToSpeech?=null

    private var listn:ArrayList<List3>?=null
    private var timer: CountDownTimer? = null
    private var timer1: CountDownTimer? = null
    private var bool= true
    var result11: Int = 0
    var result1: Int = 0
    var position: Int = 0
    var tc: Int = 0
    var result2:Int=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        binding2 = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding2?.root)
        setContentView(binding?.root)
        speak1k= TextToSpeech(this,this)
        val k1 = intent.getStringExtra("Nam")
        if(k1=="FULL BODY"){
            listn= List4().king()
        }
        if(k1=="CHEST"){
            listn= List4().king1()
        }
        if(k1=="ABS"){
            listn= List4().king2()
        }
        if(k1=="LEG"){
            listn= List4().king3()
        }

       if(k1=="BACK"){
            listn= List4().king4()
        }

        //setContentView(R.layout.activity_main5)


        binding?.textView4?.text = listn!![position].txt3
        binding?.textView6?.text = listn!![position].txt4
        binding?.gifImageView?.setImageResource(listn!![position].img1)

        if(position==0){
            sppech(binding?.textView4?.text as String)
            tim1()

        }
        else {
            tim1()
        }
        binding?.fram911?.setOnClickListener{
            binding?.fram911?.visibility=View.GONE
            binding?.fram9111?.visibility=View.VISIBLE
          timer?.cancel()


        }
        binding?.fram9111?.setOnClickListener{
            binding?.fram911?.visibility=View.VISIBLE
            binding?.fram9111?.visibility=View.GONE

            bool=false
            tim1()

        }
        binding?.fram9?.setOnClickListener {

            position = position - 1
            ima1()
            result1 = 0
            timer?.start()
        }
            binding?.fram91?.setOnClickListener{
                position = position + 1
                timer?.cancel()
                ima1()
                result11= 0
                tim2()





        }
binding?.fram8?.setOnClickListener{
    timer1?.cancel()
    bool=true
    if (position != listn?.size) {
        ima1()
        tim1()
        result1 = 0
    }

}
binding?.textView6?.setOnClickListener {
    onBackPressed()
}





    }
    private fun simple(){

        binding?.progress11?.max=30
        result1++
        result2 = result1
        binding?.progress11?.progress = 30 - result1
        binding?.tvn1?.text = (30 - result1).toString()

    }



private fun customDialog(){
    var custom = Dialog(this)
    val binding3:CustomdialogBinding?=null
     val dib=CustomdialogBinding.inflate(layoutInflater)
    custom.setContentView(dib.root)
    custom.setCanceledOnTouchOutside(false)
    dib.button3.setOnClickListener{
      this@MainActivity5.finish()
        custom.dismiss()
    }
    dib.button4.setOnClickListener{

        custom.dismiss()
    }
    custom.show()

}

     override fun onBackPressed() {

         customDialog()
     }

    private fun ima1() {

        binding?.textView4?.text = listn!![position].txt3
        binding?.textView6?.text = listn!![position].txt4
        binding?.gifImageView?.setImageResource(listn!![position].img1)
    }
private fun sppech(string:String){
    speak1k?.speak(string,TextToSpeech.QUEUE_FLUSH,null," ")

}

    private fun tim1() {
        sppech(binding?.textView4?.text as String)

        binding?.fram331?.visibility = View.GONE
        binding?.fram31?.visibility = View.VISIBLE
        binding?.fram8?.visibility=View.GONE


        binding?.textView5?.visibility = View.VISIBLE
        binding?.textView6?.visibility = View.VISIBLE
        binding?.fram911?.visibility = View.VISIBLE

        if(position!=3) {
            binding?.fram91?.visibility = View.VISIBLE
        }
        else{

            binding?.fram91?.visibility = View.GONE

        }
        if(position!=0) {
            binding?.fram9?.visibility = View.VISIBLE
        }
        else{

            binding?.fram9?.visibility = View.GONE

        }
        binding?.fram9111?.visibility = View.INVISIBLE
        binding?.progress11?.progress = result1
        if(bool == true) {
            timer = object : CountDownTimer(30000, 1000) {

                override fun onTick(res: Long) {

                    result1++
                    result2 = result1
                    binding?.progress11?.progress = 30 - result1

                    if (result1 <20) {
                        binding?.tvn1?.text = (30 - result1).toString()
                    }
                    else{
                        binding?.tvn1?.text = (30 - result1).toString()
                        sppech(binding?.tvn1?.text as String)
                    }


                }

                override fun onFinish() {
                    position++
                    if (position == listn?.size) {
                        this@MainActivity5.finish()
                        startActivity(Intent(this@MainActivity5, MainActivity6::class.java))

                    }
                    else {
                        result11 = 0
                        tim2()
                    }
                }


            }.start()
        }
        if(bool == false) {

            var k1 = 30000-(result1*1000)
            timer = object : CountDownTimer(k1.toLong(), 1000) {

                override fun onTick(res: Long) {

                    result1++


                    binding?.progress11?.progress = 30 - result1
                    binding?.tvn1?.text = (30 - result1).toString()
                    if (result1 > 30) {

                    }


                }

                override fun onFinish() {
                    position++
                    if (position == listn?.size) {
                        startActivity(Intent(this@MainActivity5, MainActivity6::class.java))
                    }
                    result11 = 0
                    tim2()
                }


            }.start()
        }

}
    @SuppressLint("SetTextI18n")
    private fun tim2() {
        sppech("GET READY FOR NEXT EXERCISE ")
        binding?.fram331?.visibility= View.VISIBLE
        binding?.fram31?.visibility= View.GONE
        binding?.gifImageView?.setImageResource(R.drawable.meditation)
        binding?.textView4?.text="GET READY FOR NEXT EXERCISE "

        binding?.textView5?.visibility=View.INVISIBLE
        binding?.textView6?.visibility=View.INVISIBLE
        binding?.fram9?.visibility=View.INVISIBLE
        binding?.fram8?.visibility=View.VISIBLE
        binding?.fram91?.visibility=View.INVISIBLE
        binding?.fram911?.visibility=View.INVISIBLE
        binding?.fram9111?.visibility=View.INVISIBLE
        binding?.progress11?.progress = result11
        timer1 = object : CountDownTimer(20000, 1000) {

            override fun onTick(res: Long) {
                result11++
                binding?.progress311?.progress = 20 - result11

                    binding?.tvn31?.text = (20 - result11).toString()





            }

            override fun onFinish() {

                 bool=true
                if (position != listn?.size) {
                    ima1()
                    tim1()
                    result1 = 0
                }


            }

            }.start()
    }


    override fun onDestroy() {
        super.onDestroy()
        if(timer!=null){
            timer?.cancel()
        }
        if(timer1!=null){
            timer1?.cancel()
        }
        binding=null
    }


    override fun onInit(p0: Int) {
        if(p0==TextToSpeech.SUCCESS){
            var result8= speak1k?.setLanguage(Locale.ENGLISH)

        }
    }


}