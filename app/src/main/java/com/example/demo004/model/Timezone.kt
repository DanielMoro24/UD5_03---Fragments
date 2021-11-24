package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Timezone(
    @Expose
    val description: String,
    @Expose
    val offset: String
)