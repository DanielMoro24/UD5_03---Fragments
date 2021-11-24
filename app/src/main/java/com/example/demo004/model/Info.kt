package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Info(
    @Expose
    val page: Int,
    @Expose
    val results: Int,
    @Expose
    val seed: String,
    @Expose
    val version: String
)