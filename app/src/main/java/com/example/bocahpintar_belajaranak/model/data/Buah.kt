package com.example.bocahpintar_belajaranak.model.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Buah(
    val image: Int,
    val nama: String,
    val deskripsi: String,
    val audio: Int
):Parcelable