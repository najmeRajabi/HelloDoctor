package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels

class DoctorListActivity : AppCompatActivity() {
    val viewModelListDr :DoctorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_list)

        initButtons()
    }

    private fun initButtons() {
        val btnDr1 = findViewById<Button>(R.id.btn_doctor1)
        val btnDr2 = findViewById<Button>(R.id.btn_doctor2)
        val btnDr3 = findViewById<Button>(R.id.btn_doctor3)
        val buttonList = arrayListOf(btnDr1,btnDr2,btnDr3)
        for (i in 0..2){
            buttonList[i].text = viewModelListDr.doctorList[i].name
            buttonList[i].setOnClickListener {
                goToShowInfoActivity()
            }
        }
    }

    private fun goToShowInfoActivity() {
        val  intent = Intent(this , DoctorActivity::class.java)
        startActivity(intent)
    }
}