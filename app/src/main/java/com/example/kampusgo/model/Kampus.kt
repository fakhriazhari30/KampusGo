package com.example.kampusgo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kampus(
        val deskripsi: String,
        val gambar: String,
        val latitude: String,
        val longitude: String,
        val nama_kampus: String
) : Parcelable