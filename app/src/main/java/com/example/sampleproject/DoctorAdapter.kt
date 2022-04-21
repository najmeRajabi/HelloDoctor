package com.example.sampleproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(private val dataSet :ArrayList<Doctor>) :
RecyclerView.Adapter<DoctorAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            textView = view.findViewById(R.id.txv_list_row)
            imageView = view.findViewById(R.id.img_doctor)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.doctor_list_row, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].name
        dataSet[position].imageId?.let { holder.imageView.setImageResource(it) }
    }

    override fun getItemCount() = dataSet.size

}