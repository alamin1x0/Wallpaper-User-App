package com.developeralamin.loveadmindashaboar.ui.categoriesActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.developeralamin.loveadmindashaboar.adapter.CatImageAdapter
import com.developeralamin.loveadmindashaboar.databinding.ActivityCategoriesBinding
import com.developeralamin.loveadmindashaboar.model.BomModel
import com.google.firebase.firestore.FirebaseFirestore

class CategoriesActivity : AppCompatActivity() {

    lateinit var binding: ActivityCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bd = FirebaseFirestore.getInstance()
        val uid = intent.getStringExtra("uid")
        val name = intent.getStringExtra("name")

        bd.collection("categories").document(uid!!).collection("wallpaper")
            .addSnapshotListener { value, error ->

                val listofCatWallpaper = arrayListOf<BomModel>()
                val data = value?.toObjects(BomModel::class.java)
                listofCatWallpaper.addAll(data!!)

                binding.catTitle.text=name.toString()
                binding.catCount.text="${listofCatWallpaper.size} Wallpaper Available"

                binding.catRev.layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.catRev.adapter = CatImageAdapter(this, listofCatWallpaper)

            }

    }
}