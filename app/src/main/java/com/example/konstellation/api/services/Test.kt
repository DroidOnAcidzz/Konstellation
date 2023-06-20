package com.example.konstellation.api.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface Test {
    interface ApiService {
        //GET ROOM ID
        @GET("/_matrix/client/r0/directory/room/{roomAlias}")
        suspend fun getRoomID(@Path("roomAlias") roomAlias:String): Int
    }

}