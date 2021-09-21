package com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto

import com.hitmeows.portfolio_yadav_ashish_02.domain.model.CodeforcesInfo

data class CodeforcesUserInfoDto(
    val result: List<Result>,
    val status: String
)

fun CodeforcesUserInfoDto.toCodeforcesInfo(): CodeforcesInfo {
    return CodeforcesInfo(result[0].maxRating,result[0].rating)
}