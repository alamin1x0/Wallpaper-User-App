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

class BomAdapter(val requireContext: Context, val listBesOfTheMonth: ArrayList<BomModel>) :
    RecyclerView.Adapter<BomAdapter.bomViewHolder>() {


    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.bom_images)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {

        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_bom, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(listBesOfTheMonth[position].link).into(holder.imageView)

        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, FinalWallpaperActivity::class.java)
            intent.putExtra("link", listBesOfTheMonth[position].link)
            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount() = listBesOfTheMonth.size

}