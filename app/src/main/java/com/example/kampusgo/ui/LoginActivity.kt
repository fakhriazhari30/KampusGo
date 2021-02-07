package com.example.kampusgo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.kampusgo.R
import com.example.kampusgo.util.Constant
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            val email = tv_email.text.toString()
            val password = tv_password.text.toString()

            val jsonobj = JSONObject()

            jsonobj.put("email", email)
            jsonobj.put("password", password)

            val queue = Volley.newRequestQueue(this)
            val url = "${Constant.BASE_URL}/user/login"

            val jsonRequest = JsonObjectRequest(Request.Method.POST, url, jsonobj,
                Response.Listener { response ->
                    Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, HomeActivity::class.java))
                },
                Response.ErrorListener { response ->
                    Toast.makeText(this, "${response.toString()}", Toast.LENGTH_SHORT).show()
                })

            queue.add(jsonRequest)
        }

        btn_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}