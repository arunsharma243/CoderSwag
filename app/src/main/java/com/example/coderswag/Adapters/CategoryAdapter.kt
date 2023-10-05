package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.Model.Category
import com.example.coderswag.R



class CategoryAdapter(context: Context, categories:List<Category>): BaseAdapter() {
    val context=context
    val categories=categories
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView:View
        val holder:ViewHolder
        if(convertView==null)
        {
            categoryView=LayoutInflater.from(context).inflate(R.layout.category_list_item,null)
            holder= ViewHolder()
            holder.categoryImage=categoryView.findViewById(R.id.categoryImage)
            holder.categoryName=categoryView.findViewById(R.id.categoryName)
             println("first time")
            categoryView.tag=holder
//            val categoryImage:ImageView=categoryView.findViewById(R.id.categoryImage)
//            val categoryName:TextView=categoryView.findViewById(R.id.categoryName)
        }
        else{
            holder=convertView.tag as ViewHolder
            categoryView=convertView
        println("recycle")
        }

        val category=categories[position]

        val resourceId=context.resources.getIdentifier(category.image,"drawable",context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        println(resourceId)

        holder.categoryName?.text=category.title
        return categoryView
    }
    override fun getItem(position: Int): Any {
        return categories[position]
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getCount(): Int {
       return categories.count()
    }
private class ViewHolder{
    var categoryImage:ImageView?=null
    var categoryName:TextView?=null
}

}