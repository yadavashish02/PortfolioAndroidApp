package com.hitmeows.portfolio_yadav_ashish_02.domain.use_case.get_codeforces_rating

import com.hitmeows.portfolio_yadav_ashish_02.common.Resource
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.toCodeforcesInfo
import com.hitmeows.portfolio_yadav_ashish_02.domain.model.CodeforcesInfo
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.CodeforcesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCodeforcesInfoUseCase @Inject constructor(
    private val repository: CodeforcesRepository
) {
    operator fun invoke(handle: String): Flow<Resource<CodeforcesInfo>> = flow {
        try {
            emit(Resource.Loading<CodeforcesInfo>())
            val info = repository.getUserInfoByHandle(handle).toCodeforcesInfo()
            emit(Resource.Success<CodeforcesInfo>(info))
        } catch (e: HttpException) {
            emit(Resource.Error<CodeforcesInfo>(e.localizedMessage ?: "unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error<CodeforcesInfo>("servers unreachable"))
        }

    }
}