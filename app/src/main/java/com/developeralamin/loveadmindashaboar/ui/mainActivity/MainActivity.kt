package com.developeralamin.loveadmindashaboar.ui.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.developeralamin.loveadmindashaboar.R
import com.developeralamin.loveadmindashaboar.databinding.ActivityMainBinding
import com.developeralamin.loveadmindashaboar.ui.downloadFragment.DownloadFragment
import com.developeralamin.loveadmindashaboar.ui.homeFragment.HomeFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
//    lateinit var adView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.root)

        replaceFragmnet(HomeFragment())

//        MobileAds.initialize(this) {}
//        adView = findViewById(R.id.adView)
//        val adRequest = AdRequest.Builder().build()
//        adView.loadAd(adRequest)


        binding.icHome.setOnClickListener {
            replaceFragmnet(HomeFragment())
        }

        binding.icDownload.setOnClickListener {
            replaceFragmnet(DownloadFragment())
        }
    }

    fun replaceFragmnet(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmenReplace, fragment)
        transaction.commit()
    }
}