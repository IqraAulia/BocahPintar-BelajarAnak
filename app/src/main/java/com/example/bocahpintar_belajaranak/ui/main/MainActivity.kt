package com.example.bocahpintar_belajaranak.ui.main

import android.Manifest
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.example.bocahpintar_belajaranak.R
import com.example.bocahpintar_belajaranak.databinding.ActivityMainBinding
import com.example.bocahpintar_belajaranak.model.ViewModelFactory
import com.example.bocahpintar_belajaranak.ui.kategori.KategoriActivity
import com.example.bocahpintar_belajaranak.ui.login.LoginActivity
import com.example.bocahpintar_belajaranak.ui.upload.UploadActivity
import com.example.bocahpintar_belajaranak.utils.getImageUri

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentImageUri: Uri? = null
    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        supportActionBar?.show()
        viewModel.getUser().observe(this){
            if (!it.isLogin){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            binding.welcome.setText(resources.getString(R.string.welcome, it.name ))

        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        binding.btnKategori.setOnClickListener{
           val intent = Intent(this, KategoriActivity::class.java)
            startActivity(intent)
        }
        binding.btnKamera.setOnClickListener {
            val intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)
        }



    }


}