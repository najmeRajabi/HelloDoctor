package com.example.sampleproject

import java.time.LocalDateTime

object Hospital{
    val doctorList = arrayListOf<Doctor>()
    val consultancyList = arrayListOf(
        Consulatancy(1,12,ConsultancyType.Phone,25000),
        Consulatancy(2,14,ConsultancyType.Video,24000),
        Consulatancy(3,17,ConsultancyType.Phone,25000)
    )
    fun getDoctor(id : Int) : Doctor?{
        for (doctor in doctorList){
            if (doctor.id == id){
                return doctor
            }
        }
        return null
    }

    fun setTestDate(){
        doctorList.clear()
        doctorList.add(Doctor(1 , "Dr. sara" ,  OnlineStatus.Offline , "روانشناسی و مشاوره" ,R.drawable.doctor_icon))
        doctorList.add(Doctor(2 , "Dr. rostam" , OnlineStatus.Online , "روانشناسی و مشاوره" ))
    }
}



data class Doctor(val id :Int ,
val name :String,
var onlineStatus :OnlineStatus,
val field:String ,
var imageId:Int? = null) {
}

data class Consulatancy (val id: Int,
val time:Int ,
val type :ConsultancyType ,
var price :Int){}

enum class ConsultancyType{
    Phone , Video
}
enum class OnlineStatus{
    Online, Offline
}