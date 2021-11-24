package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Picture(
    @Expose
    val large: String,
    @Expose
    val medium: String,
    @Expose
    val thumbnail: String
)