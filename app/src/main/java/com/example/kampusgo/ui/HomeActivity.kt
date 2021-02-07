package com.example.kampusgo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kampusgo.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        daftarkampus.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }

        logout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}