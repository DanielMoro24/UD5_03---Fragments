package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Street(
    @Expose
    val name: String,
    @Expose
    val number: Int
)