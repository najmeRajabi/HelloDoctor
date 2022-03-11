package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels

class DoctorListActivity : AppCompatActivity() {
    val vModel : DoctorListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_list)

        showDoctorList()

    }

    private fun showDoctorList() {
        var button1 = findViewById<Button>(R.id.buttonDr1)
        var button2 = findViewById<Button>(R.id.buttonDr2)
        var button3 = findViewById<Button>(R.id.buttonDr3)
        button1.apply{
            text = vModel.doctorList[0].name
            setOnClickListener{
                gotoDoctorInfo(0)
            }
        }
        button2.apply{
            text = vModel.doctorList[1].name
            setOnClickListener{
                gotoDoctorInfo(1)
            }
        }
        button3.apply{
            text = vModel.doctorList[2].name
            setOnClickListener{
                gotoDoctorInfo(2)
            }
        }
    }

    private fun gotoDoctorInfo(index: Int) {
        val intent = Intent(this, DoctorActivity::class.java)
        intent.putExtra("index" , index)
        startActivity(intent)
    }
}