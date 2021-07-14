package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Number Listeners
        binding.btn0.setOnClickListener {appendOnClick(true,"0")}
        binding.btn00.setOnClickListener {appendOnClick(true,"00")}
        binding.btn1.setOnClickListener {appendOnClick(true,"1")}
        binding.btn2.setOnClickListener {appendOnClick(true,"2")}
        binding.btn3.setOnClickListener {appendOnClick(true,"3")}
        binding.btn4.setOnClickListener {appendOnClick(true,"4")}
        binding.btn5.setOnClickListener {appendOnClick(true,"5")}
        binding.btn6.setOnClickListener {appendOnClick(true,"6")}
        binding.btn7.setOnClickListener {appendOnClick(true,"7")}
        binding.btn8.setOnClickListener {appendOnClick(true,"8")}
        binding.btn9.setOnClickListener {appendOnClick(true,"9")}
        binding.btnDot.setOnClickListener {appendOnClick(true,".")}

        //Operator Listeners
        binding.btnPlus.setOnClickListener {appendOnClick(false,"+")}
        binding.btnMinus.setOnClickListener {appendOnClick(false,"-")}
        binding.btnMultiply.setOnClickListener {appendOnClick(false,"*")}
        binding.btnDivide.setOnClickListener {appendOnClick(false,"/")}
        binding.btnLeftB.setOnClickListener {appendOnClick(false,"(")}
        binding.btnRightB.setOnClickListener {appendOnClick(false,")")}
        binding.btnClear.setOnClickListener {clear()}
        binding.btnEqual.setOnClickListener {calculate()}



    }
    //create methods
    fun appendOnClick(clear: Boolean,string: String){
        if (clear){
            binding.tvOutput.text=""
            tvInput.append(string)
        }else{
            binding.tvInput.append(binding.tvOutput.text)
            binding.tvInput.append(string)
            binding.tvOutput.text = ""
        }
    }

    fun clear(){
            binding.tvInput.text=""
            binding.tvOutput.text = ""

    }

   private fun calculate(){
        try {
           //using ExpressionBuilder
            val input = ExpressionBuilder(binding.tvInput.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if (output == longOutput.toDouble()){
                binding.tvOutput.text = longOutput.toString()
            }else{
                binding.tvOutput.text = output.toString()
            }

        }catch (e:Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}