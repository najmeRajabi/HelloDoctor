package com.example.sampleproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(var dataSet :ArrayList<Doctor>) :
RecyclerView.Adapter<DoctorAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txvDoctorName= view.findViewById<TextView>(R.id.txv_list_row)
        val imageView: ImageView= view.findViewById(R.id.img_doctor)

        fun bind(doctor: Doctor){
            txvDoctorName.text = doctor.name
            doctor.imageId?.let { imageView.setImageResource(it) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.doctor_list_row, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}