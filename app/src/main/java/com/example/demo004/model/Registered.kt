package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Registered(
    @Expose
    val age: Int,
    @Expose
    val date: String
)