package com.example.kampusgo.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.kampusgo.R
import com.example.kampusgo.util.Constant
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register1.setOnClickListener {
            val name = tx_name.text.toString()
            val email = tx_email.text.toString()
            val password = tx_password.text.toString()

            val jsonobj = JSONObject()

            jsonobj.put("name", name)
            jsonobj.put("email", email)
            jsonobj.put("password", password)

            val queue = Volley.newRequestQueue(this)
            val url = "${Constant.BASE_URL}/user/register"

            val jsonRequest = JsonObjectRequest(
                    Request.Method.POST, url, jsonobj,
                    Response.Listener { response ->
                        Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, LoginActivity::class.java))
                    },
                    Response.ErrorListener { response ->
                        Toast.makeText(this, "${response.toString()}", Toast.LENGTH_SHORT).show()
                    })

            queue.add(jsonRequest)
        }
    }
}