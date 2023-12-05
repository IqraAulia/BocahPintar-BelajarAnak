package com.example.bocahpintar_belajaranak.ui.kategori

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bocahpintar_belajaranak.R
import com.example.bocahpintar_belajaranak.databinding.ActivityKategoriBinding
import com.example.bocahpintar_belajaranak.databinding.ActivityLoginBinding
import com.example.bocahpintar_belajaranak.ui.card.CardActivity
import com.example.bocahpintar_belajaranak.ui.main.MainActivity

class KategoriActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKategoriBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKategoriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.kategoriBuah.setOnClickListener {
            val intent = Intent(this, CardActivity::class.java)
            startActivity(intent)
        }
        binding.kembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}