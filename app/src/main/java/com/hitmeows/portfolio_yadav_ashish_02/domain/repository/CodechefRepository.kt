package com.hitmeows.portfolio_yadav_ashish_02.domain.repository

import com.hitmeows.portfolio_yadav_ashish_02.common.Resource
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.CodechefRatingDto
import com.hitmeows.portfolio_yadav_ashish_02.domain.model.CodechefRating

interface CodechefRepository {
    suspend fun getCodechefRatingByHandle(handle: String): CodechefRatingDto
}