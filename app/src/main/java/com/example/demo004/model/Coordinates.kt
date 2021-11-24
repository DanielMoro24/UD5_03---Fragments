package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Coordinates(
    @Expose
    val latitude: String,
    @Expose
    val longitude: String
)