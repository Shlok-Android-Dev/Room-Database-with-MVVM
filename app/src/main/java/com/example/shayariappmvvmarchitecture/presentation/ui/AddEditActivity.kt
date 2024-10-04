package com.example.shayariappmvvmarchitecture.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.shayariappmvvmarchitecture.R
import com.example.shayariappmvvmarchitecture.data.DataEntity
import com.example.shayariappmvvmarchitecture.databinding.ActivityAddEditBinding
import com.example.shayariappmvvmarchitecture.presentation.viewmodel.ShayariViewModel
import java.util.Date

class AddEditActivity : AppCompatActivity() {

    private var id: Int = 6
        val TAG = "AddEditActivity"
    private lateinit var binding: ActivityAddEditBinding
    private val shayariViewModel: ShayariViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = "Add Your Shayari"

        binding.addSayariBtn.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val sayari = binding.sayariEditText.text.toString()

            id++

            if (title.isNotEmpty() && sayari.isNotEmpty()) {
                val newShayari = DataEntity(0,Date(),title, sayari) // 0 means autogenerate ID
                shayariViewModel.insertShayari(newShayari)

                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()

                binding.titleEditText.text.clear()
                binding.sayariEditText.text.clear()
            } else {
                binding.titleEditText.error = "Enter Title"
                binding.sayariEditText.error = "Enter Shayari"
            }
        }
    }
}