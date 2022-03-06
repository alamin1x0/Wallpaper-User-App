package com.developeralamin.loveadmindashaboar.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.developeralamin.loveadmindashaboar.R
import com.developeralamin.loveadmindashaboar.model.CatModel
import com.developeralamin.loveadmindashaboar.ui.categoriesActivity.CategoriesActivity

class CatAdapter(val requireContext: Context, val listOfCategory: ArrayList<CatModel>) :
    RecyclerView.Adapter<CatAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.cat_img)
        val name = itemView.findViewById<TextView>(R.id.cat_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {

        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_cat, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        holder.name.text = listOfCategory[position].name
        Glide.with(requireContext).load(listOfCategory[position].link).into(holder.imageView)

        holder.imageView.setOnClickListener {
            val intent = Intent(requireContext, CategoriesActivity::class.java)
            intent.putExtra("uid",listOfCategory[position].id)
            intent.putExtra("name",listOfCategory[position].name)
            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount() = listOfCategory.size
}