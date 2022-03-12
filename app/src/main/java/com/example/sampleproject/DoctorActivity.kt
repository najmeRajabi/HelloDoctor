package com.example.sampleproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.sampleproject.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    private val viewModelDr: DoctorViewModel by viewModels()
    lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoctorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()

    }

    private fun initViews() {
        chooseDoctor(intent.getIntExtra("index" , 0))
    }

    private fun call(tel:String){
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$tel")
        startActivity(callIntent)
    }
    fun chooseDoctor(index:Int){
        Hospital.setTestDate()
        binding.nameTxv.text = viewModelDr.doctorList[index].name
        binding.infoTxv.text = viewModelDr.doctorList[index].field
        binding.isConnect.text = viewModelDr.doctorList[index].onlineStatus.name

        var cons1 = Hospital.consultancyList[0]
        binding.callTxv.text = "مشاوره ی تلفنی"+cons1.time+"دقیقه ای"
        binding.priceTxv.text = cons1.price.toString() +" تومان "

        var cons2 = Hospital.consultancyList[1]
        binding.callTxv2.text = "مشاوره ی تلفنی"+cons2.time+"دقیقه ای"
        binding.priceTxv2.text = cons2.price.toString() +" تومان "

        var cons3 = Hospital.consultancyList[2]
        binding.callTxv3.text = "مشاوره ی تلفنی"+cons3.time+"دقیقه ای"
        binding.priceTxv3.text = cons3.price.toString() +" تومان "

        binding.llConsultancy.setOnClickListener {
            goToConsulate(index)
        }
        binding.llConsultancy2.setOnClickListener {
            goToConsulate(index)
        }
        binding.llConsultancy3.setOnClickListener {
            goToConsulate(index)
        }
        val tel = viewModelDr.doctorList[index].phoneNumber
        binding.callToDrBtn.setOnClickListener { call(tel) }
    }
    private fun goToConsulate(index: Int){
        val intent = Intent(this , ConsultActivity::class.java)
        intent.putExtra("index" , index)
        startActivity(intent)
    }
}