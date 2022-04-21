package com.example.sampleproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView

class DoctorListActivity : AppCompatActivity() {
    val viewModelListDr :DoctorViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_list)

        initButtons()
        initRecycler()
    }

    private fun initRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_dr_list)
        val adapter = DoctorAdapter(arrayListOf()
        ) {doctor ->
            goToShowInfoActivity(doctor.id-1)
        }
        adapter.dataSet= viewModelListDr.doctorList
        adapter.notifyDataSetChanged()


        recyclerView.adapter = adapter
//        recyclerView.notifyDataSetChange()
    }

    private fun initButtons() {
        val btnDr1 = findViewById<Button>(R.id.btn_doctor1)
        val btnDr2 = findViewById<Button>(R.id.btn_doctor2)
        val btnDr3 = findViewById<Button>(R.id.btn_doctor3)
        val buttonList = arrayListOf(btnDr1,btnDr2,btnDr3)
        for (i in 0..2){
            buttonList[i].apply {
                text = viewModelListDr.doctorList[i].name
                setOnClickListener {
                    goToShowInfoActivity(i)
                }
            }
        }
    }

    private fun goToShowInfoActivity(index:Int) {
        val  intent = Intent(this , DoctorActivity::class.java)
        intent.putExtra("index" , index)
        startActivity(intent)
    }
}