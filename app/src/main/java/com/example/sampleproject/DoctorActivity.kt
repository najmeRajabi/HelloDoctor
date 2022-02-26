package com.example.sampleproject

import android.content.Intent
import android.net.Uri
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
        chooseDoctor(0)
        chooseDoctor(1)
//        chooseDoctor(2)



    }
    private fun call(tel:String){
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:$tel")
        startActivity(callIntent)
    }
    fun chooseDoctor(id:Int){
        Hospital.setTestDate()
        var myDoctor = Hospital.doctorList[id]
        binding.nameTxv.text = myDoctor.name
        binding.infoTxv.text = myDoctor.field
        binding.isConnect.text = myDoctor.onlineStatus.name

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
            goToConsulate(0)
        }
        binding.llConsultancy2.setOnClickListener {
            goToConsulate(0)
        }
        binding.llConsultancy3.setOnClickListener {
            goToConsulate(0)
        }
        val tel = myDoctor.phoneNumber
        binding.callToDrBtn.setOnClickListener { call(tel) }
    }
    fun goToConsulate(id: Int){
        Hospital.setTestDate()
        var myDoctor = Hospital.doctorList[id]
        Toast.makeText(this , "consultancy is chosen" , Toast.LENGTH_SHORT).show()
        val intent = Intent(this , ConsultActivity::class.java)
        intent.putExtra("id" , myDoctor.id)
        startActivity(intent)
    }
}