package com.example.coderswag.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswag.Adapters.ProductAdapter
import com.example.coderswag.R
import com.example.coderswag.Services.DataService
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import com.example.coderswag.databinding.ActivityMainBinding
import com.example.coderswag.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_products)
       val categoryType=intent.getStringExtra(EXTRA_CATEGORY)
        adapter= ProductAdapter(this,DataService.getProduct(categoryType.toString()))

        var spanCount=2
        val orientation=resources.configuration.orientation

        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            spanCount=3
        }
        val screenSize=resources.configuration.screenWidthDp
        if(screenSize>720)
        {
            spanCount=3
        }

        val layoutManager=GridLayoutManager(this,spanCount)
        binding.productsListView.layoutManager=layoutManager
        binding.productsListView.adapter=adapter
    }
}