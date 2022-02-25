package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sampleproject.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoctorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()
    }

    private fun initViews() {
        Hospital.setTestDate()
        var myDoctor = Hospital.doctorList[0]
        binding.nameTxv.text = myDoctor.name
        binding.infoTxv.text = myDoctor.field
        binding.isConnect.text = myDoctor.onlineStatus.name

        var cons1 = Hospital.consultancyList[0]
        binding.callTxv.text = "مشاوره ی تلفنی"+cons1.time+"دقیقه ای"
        binding.priceTxv.text = cons1.price.toString() +" تومان "

        binding.llConsultancy.setOnClickListener {
            Toast.makeText(this , "consultancy is chosen" , Toast.LENGTH_SHORT).show()
            val intent = Intent(this , ConsultActivity::class.java)
            intent.putExtra("id" , myDoctor.id)
            startActivity(intent)
        }
    }
}