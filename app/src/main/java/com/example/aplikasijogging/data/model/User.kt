package com.example.aplikasijogging.data.model

import android.net.Uri

data class User(
    val name: String = "",
    val gender: Gender = Gender.PRIA,
    val beratInKg: Float = 0.0f,
    val imgUri: Uri? = null
)
