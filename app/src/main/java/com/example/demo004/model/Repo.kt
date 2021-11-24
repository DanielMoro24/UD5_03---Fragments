package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Repo(
    @Expose
    val cell: String,
    @Expose
    val dob: Dob,
    @Expose
    val email: String,
    @Expose
    val gender: String,
    @Expose
    val id: Id,
    @Expose
    val location: Location,
    @Expose
    val login: Login,
    @Expose
    val name: Name,
    @Expose
    val nat: String,
    @Expose
    val phone: String,
    @Expose
    val picture: Picture,
    @Expose
    val registered: Registered
)