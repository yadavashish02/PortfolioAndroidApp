package com.hitmeows.portfolio_yadav_ashish_02.presentation.rating

import com.hitmeows.portfolio_yadav_ashish_02.domain.model.CodechefRating

data class CodechefState(
    val isLoading: Boolean = false,
    val rating: CodechefRating? = null,
    val error: String = ""
)
