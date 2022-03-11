package com.example.sampleproject

import androidx.lifecycle.ViewModel

class DoctorViewModel : ViewModel() {
    fun setDoctor(index: Int) {
        doctorIndex = index
        doctor = Hospital.doctorList[index]
    }

    var doctorIndex: Int = 0
    lateinit var doctor : Doctor
    val consultancyList = Hospital.consultancyList
}