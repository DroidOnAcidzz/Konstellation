package com.example.konstellation.api.matrix.requests

data class LoginRequest(
    val identifier: Identifier,
    val initial_device_display_name: String,
    val password: String,
    val type: String
)