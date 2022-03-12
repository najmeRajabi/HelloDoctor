package com.example.sampleproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.sampleproject.databinding.ActivityConsultBinding

class ConsultActivity : AppCompatActivity() {
    private val viewModelDr: DoctorViewModel by viewModels()
    lateinit var binding : ActivityConsultBinding
    var checked: BooleanArray? = null

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                checked = intent?.getBooleanArrayExtra("checked")
                Toast.makeText(this, "isOk value is : " + checked, Toast.LENGTH_SHORT).show()
                checked?.let {
                    if (!it.contains(false))
                        Toast.makeText(this, "الان دکتر بهت زنگ می زنه", Toast.LENGTH_SHORT).show()

                }
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        editTextVisibility()
        initViews()
    }

    private fun initViews() {
        editTextVisibility()

        val index = intent.getIntExtra("index" , -1)
        if (index == -1){
            binding.textViewDoctorCalls.text = "ٔدکتر شما پیدا نشد"
        }else {
            val myDoctor =viewModelDr.doctorList[index]
            if (myDoctor.onlineStatus == OnlineStatus.Offline){
                binding.textViewDoctorCalls.text = "دکتر ${myDoctor?.name} درحال حاضر آفلاین است و نمی تواند با شما تماس بگیرد."
            }else {
                binding.textViewDoctorCalls.text = "دکتر ${myDoctor?.name} با شما تماس خواهد گرفت"
            }
            binding.buttonDrCall.isEnabled  = myDoctor.onlineStatus == OnlineStatus.Online
        }


        binding.buttonDrCall.setOnClickListener {
            if (tellValidation() || !getFromShared_tel().isNullOrBlank() ) {

                val intent = Intent(this, AnswerActivity::class.java)
                startForResult.launch(intent)
                if (checked?.contains(false) == false) {
                    Toast.makeText(this, getString(R.string.doctor_calls_you), Toast.LENGTH_SHORT)
                        .show()
                }

                val username = binding.editTextName.text.toString()
                val userTel = binding.editTextTel.text.toString()

                saveInShared(username, userTel)
                binding.editTextName.visibility = View.GONE
                binding.editTextTel.visibility = View.GONE
            }
        }
    }

    private fun editTextVisibility() {
        if (!getFromShared_name().isNullOrBlank()) {
            binding.editTextName.visibility = View.GONE
        }
        if (!getFromShared_tel().isNullOrBlank()) {
            binding.editTextTel.visibility = View.GONE
        }
    }

    private fun tellValidation():Boolean {
        return if (binding.editTextTel.text.trim().length != 11){
            binding.editTextTel.error = "لطفا شماره تلفن را صحیح وارد کنید. مثل: 09120000000"
            false
        }else{
            true
        }
    }

    private fun saveInShared(username: String, userTel: String) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name" , username)
        editor.putString("tel" , userTel)
        editor.apply()
    }
    private fun getFromShared_name(): String? {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        return sharedPreferences.getString("name", "")
    }
    private fun getFromShared_tel(): String? {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        return sharedPreferences.getString("tel", "")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("doctorName" , "sara")
        }
        super.onSaveInstanceState(outState)
    }

}