package com.example.shayariappmvvmarchitecture.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shayariappmvvmarchitecture.R
import com.example.shayariappmvvmarchitecture.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

   private lateinit var  binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

binding  = ActivityDetailBinding.inflate(layoutInflater)
        val shayari = intent.getStringExtra("shayari_data")
        binding.shayariTextView.text = shayari
    }
}