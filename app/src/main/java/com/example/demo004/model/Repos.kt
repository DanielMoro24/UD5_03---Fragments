package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Repos(
    @Expose
    val info: Info,
    @Expose
    val results: List<Repo>
)