package com.hitmeows.portfolio_yadav_ashish_02.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import org.jsoup.nodes.Document

interface CodechefApi {
    @GET("users/{handle}")
    suspend fun getCodechefRatingByHandle(
        @Path("handle") handle: String
    ): Document
}