package com.hitmeows.portfolio_yadav_ashish_02.data.repository

import com.hitmeows.portfolio_yadav_ashish_02.data.remote.CodeforcesApi
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.CodeforcesUserInfoDto
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.CodeforcesRepository
import javax.inject.Inject

class CodeforcesRepositoryImpl @Inject constructor(
    private val api: CodeforcesApi
): CodeforcesRepository {
    override suspend fun getUserInfoByHandle(handle: String): CodeforcesUserInfoDto {
        return api.getCodeforcesInfoByHandle(handle)
    }
}