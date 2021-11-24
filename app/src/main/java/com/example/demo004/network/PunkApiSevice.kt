package com.example.demo004.network

import com.example.demo004.model.Repos
import retrofit2.Call
import retrofit2.http.GET

interface PunkApiSevice {
    @GET("?results=50")
    fun getAllRepos(): Call<Repos>
    @GET("results/1")
    fun findRepoById(email: String): Call<Repos>
}