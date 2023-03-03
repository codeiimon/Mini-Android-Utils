package com.example.androidtutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.example.androidtutorials.databinding.ActivityMainBinding
import com.example.androidtutorials.databinding.CustomToastBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var customToastView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var counter = 0

        binding.btnCount.setOnClickListener() {
            var tvCounting = binding.tvCounting
            counter += 1
            tvCounting.text = "Let's count together: $counter"


        }

        binding.btnAdd.setOnClickListener() {
            val firstNumber = if(binding.etFirstNumber.text.toString() != "") binding.etFirstNumber.text.toString().toDouble() else return@setOnClickListener
            val secondNumber = if(binding.etSecondNumber.text.toString() != "") binding.etSecondNumber.text.toString().toDouble() else return@setOnClickListener
            var newResult = firstNumber + secondNumber
            binding.tvResult.text = (firstNumber + secondNumber).toString()
        }

        var toggle = true
        binding.btnAddImage.setOnClickListener() {
            if(toggle) binding.ivImage.setImageResource(R.drawable.hug) else binding.ivImage.setImageDrawable(null)
            toggle = !toggle

        }

        binding.btnOrder.setOnClickListener() {
            val checkedMeatID = binding.radioGroup.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatID)

            val orderString = "You ordered:\n" +
                    "${meat.text}\n" +
                    "${if(binding.cbCheese.isChecked) "Cheese\n" else ""}" +
                    "${if(binding.cbOnions.isChecked)  "Onions\n" else ""}" +
                    "${if(binding.cbLettuce.isChecked) "Lettuce" else ""}"
            binding.tvOrder.text = orderString
        }

        customToastView = layoutInflater.inflate(R.layout.custom_toast, findViewById<View>(R.id.clToast) as ViewGroup?)

        binding.btnShowToast.setOnClickListener() {
            val toast = Toast(this@MainActivity)
            toast.duration = Toast.LENGTH_LONG
            toast.setGravity(Gravity.BOTTOM,0, 200)
            toast.view =customToastView
            toast.show()
        }
    }

}