package com.hitmeows.portfolio_yadav_ashish_02.domain.use_case.get_firebase_image

import com.google.firebase.database.DatabaseReference
import com.hitmeows.portfolio_yadav_ashish_02.common.Resource
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.dto.toCodeforcesInfo
import com.hitmeows.portfolio_yadav_ashish_02.domain.model.CodeforcesInfo
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetImageFromFirebaseUseCase @Inject constructor(
    private val repository: FirebaseRepository
) {
    operator fun invoke(name: String): Flow<Resource<DatabaseReference>> = flow {
        try {
            emit(Resource.Loading<DatabaseReference>())
            val link = repository.getImageFromFirebase(name)
            emit(Resource.Success<DatabaseReference>(link))
        } catch (e: Exception) {
            emit(Resource.Error<DatabaseReference>("error"))
        }
    }
}