package com.soleimanian.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eventHandler()
    }

    private fun eventHandler () {
        calculate_btn.setOnClickListener{
            handleClickEvent ()
        }
    }

    private fun handleClickEvent () {
        try {
            val weight = weight_el.text.toString().toFloat()
            val height = height_el.text.toString().toFloat()
            val bmi = calculate(weight, height)
            val result = interpert(bmi)
            result_tv.text = "شاخص توده بدنی: ${bmi}، شما دارای «${result}» هستید"
        } catch (e: Exception) {
            result_tv.text = "لطفا فیلدهای لازم را با مقدار مناسب پر نمایید."
        }
    }

    private fun calculate (weight: Float, height: Float): Float {
        return (weight / (height / 100) * (height / 100))
    }

    private fun interpert (bmi: Float): String {
        return when(bmi) {
            in 0f..16f -> "لاغری شدید"
            in 16f..17f -> "لاغری متوسط"
            in 17f..18.5f -> "لاغری خفیف"
            in 18.5f..25f -> "وزن ایده آل"
            in 25f..30f -> "وزن ایده آل"
            in 30f..35f -> "چاقی"
            in 35f..40f -> "چاقی شدید"
            else -> "چاقی بسیار شدید"
        }
    }
}