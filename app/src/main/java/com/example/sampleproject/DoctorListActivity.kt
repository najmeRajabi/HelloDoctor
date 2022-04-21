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


        initRecycler()
    }

    private fun initRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_dr_list)
        val adapter = DoctorAdapter(arrayListOf()
        ) {doctor ->
            goToShowInfoActivity(doctor.id-1)
        }

        adapter.submitList(viewModelListDr.doctorList)
        recyclerView.adapter = adapter
    }


    private fun goToShowInfoActivity(index:Int) {
        val  intent = Intent(this , DoctorActivity::class.java)
        intent.putExtra("index" , index)
        startActivity(intent)
    }
}