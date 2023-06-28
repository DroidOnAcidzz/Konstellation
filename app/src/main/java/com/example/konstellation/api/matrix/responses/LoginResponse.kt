package com.example.konstellation.api.matrix.responses

data class LoginResponse(
    val access_token: String,
    val device_id: String,
    val expires_in_ms: Int,
    val refresh_token: String,
    val user_id: String,
    val well_known: WellKnown
)