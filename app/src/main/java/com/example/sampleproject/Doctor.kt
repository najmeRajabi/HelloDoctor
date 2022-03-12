package com.example.sampleproject

object Hospital{
    val doctorList = arrayListOf<Doctor>(
        Doctor(1 , "Dr. sara" ,
            OnlineStatus.Online , "روانشناسی و مشاوره" ,
            "33352258",R.drawable.doctor_icon),
        Doctor(2 , "Dr. rostam" ,
            OnlineStatus.Online , "روانشناسی و مشاوره",
            "33656598" ),
        Doctor(3 , "Dr. ali" ,
            OnlineStatus.Offline , "روانشناسی و مشاوره",
            "33655952" )
    )
    val consultancyList = arrayListOf(
        Consultancy(1,12,ConsultancyType.Phone,25000),
        Consultancy(2,14,ConsultancyType.Video,24000),
        Consultancy(3,17,ConsultancyType.Phone,25000)
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
        doctorList.add(Doctor(1 , "Dr. sara" ,  OnlineStatus.Online , "روانشناسی و مشاوره" ,"33352258",R.drawable.doctor_icon))
        doctorList.add(Doctor(2 , "Dr. rostam" , OnlineStatus.Online , "روانشناسی و مشاوره","33656598" ))
        doctorList.add(Doctor(3 , "Dr. ali" , OnlineStatus.Offline , "روانشناسی و مشاوره","33655952" ))
    }
}



data class Doctor(val id :Int ,
                  val name :String,
                  var onlineStatus :OnlineStatus,
                  val field:String ,
                  var phoneNumber :String ,
                  var imageId:Int? = null) {
                }

data class Consultancy (val id: Int,
                        val time:Int,
                        val type :ConsultancyType,
                        var price :Int){}

enum class ConsultancyType{
    Phone , Video
}
enum class OnlineStatus{
    Online, Offline
}