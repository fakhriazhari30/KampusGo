package com.example.kampusgo.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.kampusgo.R
import com.example.kampusgo.adapter.KampusAdapter
import com.example.kampusgo.model.Kampus
import com.example.kampusgo.util.Constant
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val queue = Volley.newRequestQueue(this)
        val url = "${Constant.BASE_URL}/kampus"

        val jsonObjectRequest =JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    val kampusResponse = response.getJSONArray("data")
                    val kampusList = ArrayList<Kampus>()

                    for(i in 0 until kampusResponse.length()) {
                        val item = kampusResponse.getJSONObject(i)

                        val kampus = Kampus(
                                nama_kampus = item.getString("nama_kampus"),
                                deskripsi = item.getString("deskripsi"),
                                gambar = item.getString("gambar"),
                                latitude = item.getString("latitude"),
                                longitude = item.getString("longitude")
                        )
                        kampusList.add(kampus)
                    }

                    val adapter = KampusAdapter(kampusList)
                    adapter.setOnClickListener {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_KAMPUS, it)
                        startActivity(intent)
                    }
                    rvListKampus.apply {
                        this.adapter = adapter
                        layoutManager = LinearLayoutManager(this@ListActivity)
                    }

                },{ response ->
            Toast.makeText(this, "${response.toString()}", Toast.LENGTH_SHORT).show()
        }
        )
        queue.add(jsonObjectRequest)
    }
}