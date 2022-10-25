package com.example.a01

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Entity (
    val name: String,
    val establishment: String,
    val longitude: String,
    val latitude: String
): Parcelable
