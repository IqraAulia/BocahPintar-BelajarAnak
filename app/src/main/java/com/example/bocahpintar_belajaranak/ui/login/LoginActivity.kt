package com.example.bocahpintar_belajaranak.ui.login

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.bocahpintar_belajaranak.R
import com.example.bocahpintar_belajaranak.databinding.ActivityLoginBinding
import com.example.bocahpintar_belajaranak.databinding.ActivityMainBinding
import com.example.bocahpintar_belajaranak.model.UserModel
import com.example.bocahpintar_belajaranak.model.ViewModelFactory
import com.example.bocahpintar_belajaranak.ui.kategori.KategoriActivity
import com.example.bocahpintar_belajaranak.ui.main.MainActivity
import com.example.bocahpintar_belajaranak.ui.main.MainViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        supportActionBar?.hide()
        binding.lewati.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnMasuk.setOnClickListener {
            val nama = binding.nama.text.toString().trim()
            viewModel.saveUser(UserModel(nama,true))
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}