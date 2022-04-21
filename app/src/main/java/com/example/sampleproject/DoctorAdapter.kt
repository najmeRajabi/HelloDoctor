package com.example.sampleproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoctorAdapter(private val datas :ArrayList<Doctor>) :
RecyclerView.Adapter<DoctorAdapter.ViewHolder>{

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
//            textView = view.findViewById(R.id.textView)
        }
    }

}