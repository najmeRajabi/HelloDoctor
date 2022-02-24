package com.example.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoctorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        
    }
}