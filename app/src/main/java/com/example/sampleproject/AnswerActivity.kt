package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject.databinding.ActivityAnswerBinding

class AnswerActivity : AppCompatActivity() {
    lateinit var binding: ActivityAnswerBinding
    var checked  = arrayListOf<Boolean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnswerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.checkBox1.setOnClickListener{
            checked +=( binding.checkBox1.isChecked)
        }
        binding.checkBox2.setOnClickListener{
            checked +=( binding.checkBox2.isChecked)
        }
        binding.checkBox3.setOnClickListener{
            checked +=( binding.checkBox3.isChecked)
        }
        binding.checkBox4.setOnClickListener{
            checked +=( binding.checkBox4.isChecked)
        }
    }

    override fun onBackPressed() {
        back()
        super.onBackPressed()
    }

    fun back(){
        val resultIntent = Intent()
        resultIntent.putExtra("checked" , checked)
        setResult(RESULT_OK, resultIntent)
    }
}