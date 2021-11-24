package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Name(
    @Expose
    val first: String,
    @Expose
    val last: String,
    @Expose
    val title: String
)