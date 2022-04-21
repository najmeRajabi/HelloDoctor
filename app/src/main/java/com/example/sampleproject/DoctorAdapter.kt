package com.example.sampleproject



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

typealias ClickHandler = (doctor:Doctor) -> Unit

class DoctorAdapter(var dataSet :ArrayList<Doctor> ,
                    var clickHandler : ClickHandler ) :
                    ListAdapter<Doctor,DoctorAdapter.ViewHolder>(FlowerDiffCallback){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val txvDoctorName= view.findViewById<TextView>(R.id.txv_list_row_dr_name)
        val imgDoctor: ImageView = view.findViewById(R.id.img_doctor)
        val txvOnlineStatus = view.findViewById<TextView>(R.id.txv_list_onlineStatus)

        fun bind(doctor: Doctor , clickHandler : ClickHandler ){
            txvDoctorName.text = doctor.name
            doctor.imageId?.let { imgDoctor.setImageResource(it) }
            txvOnlineStatus.text = doctor.onlineStatus.name
            txvOnlineStatus.setOnClickListener {
                clickHandler(doctor)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.doctor_list_row, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position) , clickHandler)
    }

    object FlowerDiffCallback : DiffUtil.ItemCallback<Doctor>() {
        override fun areItemsTheSame(oldItem: Doctor, newItem: Doctor): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Doctor, newItem: Doctor): Boolean {
            return oldItem.id == newItem.id
        }
    }

}
