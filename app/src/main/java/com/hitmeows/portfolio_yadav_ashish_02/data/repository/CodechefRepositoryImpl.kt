package com.hitmeows.portfolio_yadav_ashish_02.data.repository

import android.util.Log
import androidx.core.text.isDigitsOnly
import com.hitmeows.portfolio_yadav_ashish_02.common.Constants
import com.hitmeows.portfolio_yadav_ashish_02.common.Resource
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.CodechefApi
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.CodechefRatingDto
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.CodeforcesUserInfoDto
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.CodechefRepository
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.CodeforcesRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import javax.inject.Inject
import kotlin.concurrent.thread

class CodechefRepositoryImpl @Inject constructor(
    private val api: CodechefApi
): CodechefRepository {
    override suspend fun getCodechefRatingByHandle(handle: String): CodechefRatingDto {
        return CodechefRatingDto(api.getCodechefRatingByHandle(handle))
    }
}