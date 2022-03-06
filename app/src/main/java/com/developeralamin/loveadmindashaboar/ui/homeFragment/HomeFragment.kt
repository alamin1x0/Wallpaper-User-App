package com.developeralamin.loveadmindashaboar.ui.homeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.developeralamin.loveadmindashaboar.adapter.BomAdapter
import com.developeralamin.loveadmindashaboar.adapter.CatAdapter
import com.developeralamin.loveadmindashaboar.adapter.ColortoneAdapter
import com.developeralamin.loveadmindashaboar.databinding.FragmentHomeBinding
import com.developeralamin.loveadmindashaboar.model.BomModel
import com.developeralamin.loveadmindashaboar.model.CatModel
import com.developeralamin.loveadmindashaboar.model.ColortoneModel
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var db: FirebaseFirestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        db = FirebaseFirestore.getInstance()

        db.collection("bestofmonth").addSnapshotListener { value, error ->
            val listBesOfTheMonth = arrayListOf<BomModel>()
            val data = value?.toObjects(BomModel::class.java)
            listBesOfTheMonth.addAll(data!!)

            binding.revBom.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.revBom.adapter = BomAdapter(requireContext(), listBesOfTheMonth)

        }

        db.collection("thecolortone").addSnapshotListener { value, error ->
            val listTheColorTone = arrayListOf<ColortoneModel>()
            val data = value?.toObjects(ColortoneModel::class.java)
            listTheColorTone.addAll(data!!)

            binding.revTct.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.revTct.adapter= ColortoneAdapter(requireContext(),listTheColorTone)

        }

        db.collection("categories").addSnapshotListener { value, error ->

            val listOfCategory = arrayListOf<CatModel>()
            val data = value?.toObjects(CatModel::class.java)
            listOfCategory.addAll(data!!)

            binding.revCat.layoutManager = GridLayoutManager(requireContext(),2)
            binding.revCat.adapter = CatAdapter(requireContext(),listOfCategory)

        }

        return binding.root
    }
}