package com.example.bocahpintar_belajaranak.ui.card

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bocahpintar_belajaranak.R
import com.example.bocahpintar_belajaranak.databinding.ActivityCardBinding
import com.example.bocahpintar_belajaranak.databinding.ActivityKategoriBinding
import com.example.bocahpintar_belajaranak.model.ListAdapter
import com.example.bocahpintar_belajaranak.model.data.DataBuah
import com.example.bocahpintar_belajaranak.ui.detail.DetailActivity
import com.example.bocahpintar_belajaranak.ui.kategori.KategoriActivity
import com.example.bocahpintar_belajaranak.ui.main.MainActivity
import javax.sql.DataSource

class CardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardBinding
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.tvCard
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = ListAdapter(DataBuah().getBuah()){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.CONTENT, it)
            startActivity(intent)
        }
        binding.kembali.setOnClickListener {
            val intent = Intent(this, KategoriActivity::class.java)
            startActivity(intent)
        }
    }
}