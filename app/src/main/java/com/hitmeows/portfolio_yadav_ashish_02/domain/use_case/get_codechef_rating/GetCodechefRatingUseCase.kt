package com.hitmeows.portfolio_yadav_ashish_02.domain.use_case.get_codechef_rating

import com.hitmeows.portfolio_yadav_ashish_02.common.Resource
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.toCodechefRating
import com.hitmeows.portfolio_yadav_ashish_02.domain.model.CodechefRating
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.CodechefRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCodechefRatingUseCase @Inject constructor(
    private val repository: CodechefRepository
) {
    operator fun invoke(handle: String): Flow<Resource<CodechefRating>> = flow {
        try {
            emit(Resource.Loading<CodechefRating>())

            val rating = repository.getCodechefRatingByHandle(handle).toCodechefRating()
            emit(Resource.Success<CodechefRating>(rating))
        } catch (e: Exception) {
            emit(Resource.Error<CodechefRating>("unknown error"))
        }
    }
}