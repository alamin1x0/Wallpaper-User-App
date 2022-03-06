package com.developeralamin.loveadmindashaboar.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.developeralamin.loveadmindashaboar.R
import com.developeralamin.loveadmindashaboar.model.ColortoneModel
import com.developeralamin.loveadmindashaboar.ui.finalWallpaper.FinalWallpaperActivity

class ColortoneAdapter(val requireContext: Context, val listTheColorTone: ArrayList<ColortoneModel>) :
    RecyclerView.Adapter<ColortoneAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    {
        val cardBack = itemView.findViewById<CardView>(R.id.item_card)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {

        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_color_tone, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        val color = listTheColorTone[position].color

        holder.cardBack.setCardBackgroundColor(Color.parseColor(color!!))

        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, FinalWallpaperActivity::class.java)
            intent.putExtra("link", listTheColorTone[position].link)
            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount() = listTheColorTone.size
}