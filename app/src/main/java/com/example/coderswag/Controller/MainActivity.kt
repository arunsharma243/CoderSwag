package com.example.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.coderswag.Adapters.CategoryAdapter
import com.example.coderswag.Model.Category
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var adapter:CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        adapter= CategoryAdapter(this,DataService.categories)
        binding.categoryListView.adapter=adapter

//        binding.categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category=DataService.categories[i]
//            Toast.makeText(this,"You clicked on the ${category.title} cell",Toast.LENGTH_SHORT).show()
        }
    }
