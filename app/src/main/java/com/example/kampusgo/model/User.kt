package com.example.kampusgo.model

import java.io.Serializable

data class User(
        val email: String,
        val name: String,
        val password: String
) : Serializable