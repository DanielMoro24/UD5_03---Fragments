package com.example.demo004.model


import com.google.gson.annotations.Expose

data class Location(
    @Expose
    val city: String,
    @Expose
    val coordinates: Coordinates,
    @Expose
    val country: String,
    @Expose
    val postcode: Any,
    @Expose
    val state: String,
    @Expose
    val street: Street,
    @Expose
    val timezone: Timezone
)