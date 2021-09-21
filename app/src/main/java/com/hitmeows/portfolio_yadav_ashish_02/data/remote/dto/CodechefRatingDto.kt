package com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto

import com.hitmeows.portfolio_yadav_ashish_02.common.Constants
import com.hitmeows.portfolio_yadav_ashish_02.domain.model.CodechefRating
import org.jsoup.nodes.Document

data class CodechefRatingDto(
    val document: Document
)

fun CodechefRatingDto.toCodechefRating(): CodechefRating {
    return CodechefRating(
        document.getElementsByClass(Constants.PARAM_CODECHEF_RATING_CLASS)
            .text().toInt()
    )
}
