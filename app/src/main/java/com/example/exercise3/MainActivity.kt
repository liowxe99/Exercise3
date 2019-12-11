package com.example.exercise3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import com.example.exercise3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonCalculate.setOnClickListener{
            calculateInsurance()
        }
        binding.buttonReset.setOnClickListener{
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkBoxSmoker.isChecked = false

        }
    }
    @SuppressLint("SetTextI18n")
    private fun calculateInsurance(){

        val result:Int = when(binding.spinnerAge.selectedItemPosition.toString().toInt()){
            1 -> 70+(if (binding.radioButtonMale.isChecked)+50 else + 0)+(if (binding.checkBoxSmoker.isChecked)+100 else +0)
            2 -> 90+(if (binding.radioButtonMale.isChecked)+100 else + 0)+(if (binding.checkBoxSmoker.isChecked)+150 else +0)
            3 -> 120+(if (binding.radioButtonMale.isChecked)+150 else + 0)+(if (binding.checkBoxSmoker.isChecked)+200 else +0)
            4 -> 150+(if (binding.radioButtonMale.isChecked)+200 else + 0)+(if (binding.checkBoxSmoker.isChecked)+250 else +0)
            5 -> 150+(if (binding.radioButtonMale.isChecked)+200 else + 0)+(if (binding.checkBoxSmoker.isChecked)+300 else +0)
            else -> 60
        }

        binding.textViewPremium.text = "Insurance Premium: $result"

    }
}
