package com.hitmeows.portfolio_yadav_ashish_02.data.remote

import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.CodechefRatingDto
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.CodeforcesUserInfoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CodeforcesApi {
    @GET("user.info")
    suspend fun getCodeforcesInfoByHandle(
        @Query("handles") handle: String
    ): CodeforcesUserInfoDto
}