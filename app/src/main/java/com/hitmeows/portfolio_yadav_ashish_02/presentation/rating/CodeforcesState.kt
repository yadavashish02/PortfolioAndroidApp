package com.hitmeows.portfolio_yadav_ashish_02.presentation.rating

import com.hitmeows.portfolio_yadav_ashish_02.domain.model.CodechefRating
import com.hitmeows.portfolio_yadav_ashish_02.domain.model.CodeforcesInfo

data class CodeforcesState(
    val isLoading: Boolean = false,
    val info: CodeforcesInfo? = null,
    val error: String = "",
)
