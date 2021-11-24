package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Login(
    @Expose
    val md5: String,
    @Expose
    val password: String,
    @Expose
    val salt: String,
    @Expose
    val sha1: String,
    @Expose
    val sha256: String,
    @Expose
    val username: String,
    @Expose
    val uuid: String
)