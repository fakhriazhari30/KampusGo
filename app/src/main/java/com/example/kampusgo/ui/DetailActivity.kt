package com.example.kampusgo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kampusgo.model.Kampus
import com.example.kampusgo.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_KAMPUS = "extra_kampus"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent.extras?.getParcelable<Kampus>(EXTRA_KAMPUS)

        tvDeskripsi.text = intent?.deskripsi
        Glide.with(this).load(intent?.gambar).into(ivKampus)
        tvNamaKampus.text = intent?.nama_kampus
        tvDeskripsi.text = intent?.deskripsi

        btnMaps.setOnClickListener {
            val intent2 = Intent(this, MapsActivity::class.java)
            intent2.putExtra(MapsActivity.EXTRA_KAMPUS, intent)
            startActivity(intent2)
        }

    }
}