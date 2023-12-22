package com.example.bocahpintar_belajaranak.ui.detail

import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bocahpintar_belajaranak.R
import com.example.bocahpintar_belajaranak.databinding.ActivityDetailBinding
import com.example.bocahpintar_belajaranak.databinding.ActivityUploadBinding
import com.example.bocahpintar_belajaranak.model.data.Buah
import com.example.bocahpintar_belajaranak.ui.card.CardActivity
import com.example.bocahpintar_belajaranak.ui.kategori.KategoriActivity
import java.io.IOException

class DetailActivity : AppCompatActivity() {
    private var mMediaPlayer: MediaPlayer? = null
    private var isReady: Boolean = false
    companion object {
        const val CONTENT = "content"
    }
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buah = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getParcelableExtra(CONTENT, Buah::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(CONTENT)
        }

        if(buah != null){
            binding.nama.text = buah.nama
            binding.deskripsi.text = buah.deskripsi
            binding.imgCardPhoto.setImageResource(buah.image)
            binding.play.setOnClickListener {
                if (!isReady) {
                    mMediaPlayer?.prepareAsync()
                } else {
                    if (mMediaPlayer?.isPlaying as Boolean) {
                        mMediaPlayer?.pause()
                    } else {
                        mMediaPlayer?.start()
                    }
                }
            }
            init(buah.audio)
        }
        binding.kembali.setOnClickListener {
            val intent = Intent(this, CardActivity::class.java)
            startActivity(intent)
        }
    }
    private fun init(audio:Int) {

        mMediaPlayer = MediaPlayer()
        val attribute = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        mMediaPlayer?.setAudioAttributes(attribute)

        val afd = applicationContext.resources.openRawResourceFd(audio)
        try {
            mMediaPlayer?.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        mMediaPlayer?.setOnPreparedListener {
            isReady = true
            mMediaPlayer?.start()
        }
        mMediaPlayer?.setOnErrorListener { _, _, _ -> false }
    }
}