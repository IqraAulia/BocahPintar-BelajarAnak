package com.example.bocahpintar_belajaranak.ui.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bocahpintar_belajaranak.R
import com.example.bocahpintar_belajaranak.databinding.ActivityCardBinding
import com.example.bocahpintar_belajaranak.databinding.ActivityKategoriBinding
import com.example.bocahpintar_belajaranak.ui.kategori.KategoriActivity
import com.example.bocahpintar_belajaranak.ui.main.MainActivity

class CardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.kembali.setOnClickListener {
            val intent = Intent(this, KategoriActivity::class.java)
            startActivity(intent)
        }
    }
}