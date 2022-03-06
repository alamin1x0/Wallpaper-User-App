package com.developeralamin.loveadmindashaboar.ui.downloadFragment

import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.developeralamin.loveadmindashaboar.adapter.CollectionAdapter
import com.developeralamin.loveadmindashaboar.databinding.FragmentDownloadBinding
import java.io.File

class DownloadFragment : Fragment() {

    lateinit var binding: FragmentDownloadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDownloadBinding.inflate(layoutInflater, container, false)

        val allFiles: Array<File>
        val imageList = arrayListOf<String>()


        val targetPath =
            Environment.getExternalStorageDirectory().absolutePath + "/Pictures"
//        + "/Pictures/Amoled Wallpaper"

        val targetFile = File(targetPath)
        allFiles = targetFile.listFiles()!!

        for (data in allFiles) {
            imageList.add(data.absolutePath)
        }

        for (i in imageList) {
            Log.e("djdjjj", "onCreate" +i)
        }

        binding.revCollection.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.revCollection.adapter = CollectionAdapter(requireContext(),imageList)

        return binding.root
    }
}
