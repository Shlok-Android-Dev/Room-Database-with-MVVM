package com.example.shayariappmvvmarchitecture.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shayariappmvvmarchitecture.databinding.ActivityMainBinding
import com.example.shayariappmvvmarchitecture.presentation.adapter.ShayariAdapter
import com.example.shayariappmvvmarchitecture.presentation.viewmodel.ShayariViewModel
import com.example.shayariappmvvmarchitecture.presentation.viewmodel.ShayariViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ShayariAdapter
    private val TAG = "MainActivity"

    // Use the viewModels delegate with a custom factory
    private val shayariViewModel: ShayariViewModel by viewModels {
        ShayariViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: $shayariViewModel.allShayari.toString()")

        // Initialize Adapter
        adapter = ShayariAdapter { dataEntity ->
            Toast.makeText(this, "clicked item ${dataEntity.title}", Toast.LENGTH_SHORT).show()
            // Handle click on Shayari item
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        // Observe LiveData from ViewModel
        shayariViewModel.allShayari.observe(this) { shayariList ->
            Log.d(TAG, "Shayari list received: $shayariList")
            adapter.submitList(shayariList)
        }

      binding.fab.setOnClickListener {
        startActivity(Intent(this, AddEditActivity::class.java))
      }


    }
}



/*
 val viewModel = viewModel<ContactsViewModeI>(
    factory = object : ViewMode1Provider. Factory {

        override fun < T : ViewModel> create (modelC1ass: Class<T>): T {
            return ContactsViewModel(
                helloWorld = "Hello world!"
            ) as T
        }
    }
     */