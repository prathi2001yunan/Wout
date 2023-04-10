package com.example.wout

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.wout.databinding.ActivityMain3Binding
import com.example.wout.databinding.Custom001Binding
import com.example.wout.databinding.CustomdialogBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class MainActivity3 : AppCompatActivity() {
    private var binding:ActivityMain3Binding?=null
    private var hii:Float=0f
    private var bmi:Float =0f
    private var inn:Boolean = true
    private var bmi2:String?=null
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_main3)

        var bh1 = findViewById<FrameLayout>(R.id.mb1)
        var brd1 = findViewById<RadioButton>(R.id.butr1)
        var brd2 = findViewById<RadioButton>(R.id.butr2)
        var tx1 = findViewById<TextInputLayout>(R.id.textin2)
        var tx2 = findViewById<TextInputLayout>(R.id.textin4)
        var tx3 = findViewById<TextInputLayout>(R.id.textin43)
        var tx4 = findViewById<TextInputLayout>(R.id.weight1)
        var tx5 = findViewById<TextInputLayout>(R.id.weight2)

        brd1.setOnClickListener{
          tx1.visibility= View.VISIBLE
           tx2.visibility= View.GONE
         tx3.visibility= View.GONE
            tx4.visibility=View.VISIBLE
            tx5.visibility=View.GONE




        }
        brd2.setOnClickListener{

         tx1.visibility= View.GONE
           tx2.visibility= View.VISIBLE
            tx3.visibility= View.VISIBLE
           tx5.visibility=View.VISIBLE
            tx4.visibility=View.GONE

            inn=false









        }


        bh1.setOnClickListener{
            val height3 = findViewById<AppCompatEditText>(R.id.height02)
            val height4 = findViewById<AppCompatEditText>(R.id.height023)


             val weight2 = findViewById<AppCompatEditText>(R.id.weight01)
             val height2 = findViewById<AppCompatEditText>(R.id.height01)
             val age2 = findViewById<AppCompatEditText>(R.id.age01)
             if(weight2.text!!.isEmpty() && height2.text!!.isEmpty()&& age2.text!!.isEmpty()) {
                 Toast.makeText(this,"PLEASE TYPE THE WEIGHT,HEIGHT AND AGE PROPERLY",Toast.LENGTH_LONG).show()
             }
             else {
                 if(inn == true) {
                     val weight: Float = weight2.text.toString().toFloat() / 100
                     val height: Float = height2.text.toString().toFloat() / 100
                     bmi = (weight / (height * height)) * 100

                     measure1(bmi)

                     onop()



                 }
                 if(inn == false) {
                     val height1 = findViewById<AppCompatEditText>(R.id.height02)
                     val height2 = findViewById<AppCompatEditText>(R.id.height023)


                     val weight3 = findViewById<AppCompatEditText>(R.id.weight012)
                     if (weight3.text!!.isEmpty() && height1.text!!.isEmpty() && age2.text!!.isEmpty() && height2.text!!.isEmpty()) {
                         Toast.makeText(
                             this,
                             "PLEASE TYPE THE WEIGHT,HEIGHT AND AGE PROPERLY",
                             Toast.LENGTH_LONG
                         ).show()
                     } else {
                         hii = (height3.text.toString().toFloat() * 30.48 + height4.text.toString().toFloat() * 2.54).toFloat()
                         val weight4 = findViewById<AppCompatEditText>(R.id.weight012)
                         val weight: Float = (weight4.text.toString().toFloat() * 0.454).toFloat() / 100
                         val height: Float = hii / 100
                         bmi = (weight / (height * height)) * 100


                         measure1(bmi)


                         onop()
                     }
                 }
             }



  }



    }

    private fun measure1(bmi:Float) {
        if(bmi<=18.5){

            bmi2 ="Oops! You are underweight"

        }
        else if(bmi<=24.9){

            bmi2 ="Awesome! You are healthy"
        }
        else if(bmi<=29.9){
            bmi2 ="Eee! You are overweight"
        }
        else{
            bmi2 ="Seesh! You are obese"
        }
    }
    private fun onop(){
        val custom = Dialog(this)
        custom.setCanceledOnTouchOutside(false)
        val binding3:Custom001Binding?=null
        val binding4=Custom001Binding.inflate(layoutInflater)
        custom.setContentView(binding4.root)
        binding4.textView12.text=bmi.toString()
        binding4.textView13.text=bmi2.toString()
        binding4.button3.setOnClickListener {
            custom.dismiss()

        }
        custom.show()





    }
    private fun customDialog(){
        var custom = Dialog(this)
        val binding3: CustomdialogBinding?=null
        val dib= CustomdialogBinding.inflate(layoutInflater)
        custom.setContentView(dib.root)
        custom.setCanceledOnTouchOutside(false)

        dib.button3.setOnClickListener{

            custom.dismiss()
        }
        dib.button4.setOnClickListener{

            custom.dismiss()
        }
        custom.show()

    }
}


