package com.chaeniiz.githubapipractice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/users/{username}/repos")

    fun getStargazerName(
            @Path("username") username: String): Call<ArrayList<Stargazer>>
}