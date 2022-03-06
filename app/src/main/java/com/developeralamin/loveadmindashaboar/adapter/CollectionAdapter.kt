package com.developeralamin.loveadmindashaboar.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.developeralamin.loveadmindashaboar.R
import com.developeralamin.loveadmindashaboar.model.BomModel
import com.developeralamin.loveadmindashaboar.ui.finalWallpaper.FinalWallpaperActivity
import com.makeramen.roundedimageview.RoundedImageView

class CollectionAdapter(val requireContext: Context, val listBesOfTheMonth: ArrayList<String>) :
    RecyclerView.Adapter<CollectionAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.catImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {

        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.wallpaper, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(listBesOfTheMonth[position]).into(holder.imageView)

    }

    override fun getItemCount() = listBesOfTheMonth.size
}