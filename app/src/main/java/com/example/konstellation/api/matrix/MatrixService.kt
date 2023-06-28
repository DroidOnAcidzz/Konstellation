package com.example.konstellation.api.matrix

import com.example.konstellation.api.matrix.requests.LoginRequest
import com.example.konstellation.api.matrix.responses.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface MatrixService {
        @POST("_matrix/client/v3/login")
        suspend fun login(@Body request: LoginRequest):Call<LoginResponse>
        @GET("/_matrix/client/r0/directory/room/{roomAlias}")
        suspend fun getRoomID(@Path("roomAlias") roomAlias:String): Int
    }
