package com.hitmeows.portfolio_yadav_ashish_02.domain.repository

import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.CodeforcesUserInfoDto

interface CodeforcesRepository {
    suspend fun getUserInfoByHandle(handle: String): CodeforcesUserInfoDto
}