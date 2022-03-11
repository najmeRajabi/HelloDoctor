package com.example.sampleproject

import androidx.lifecycle.ViewModel

class DoctorListViewModel : ViewModel(){
    var doctorList = arrayListOf<Doctor>()
    init{
        Hospital.setTestDate()
        doctorList = Hospital.doctorList
    }
}