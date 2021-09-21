package com.hitmeows.portfolio_yadav_ashish_02.presentation.rating

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.hitmeows.portfolio_yadav_ashish_02.common.Constants
import com.hitmeows.portfolio_yadav_ashish_02.common.Resource
import com.hitmeows.portfolio_yadav_ashish_02.domain.use_case.get_codechef_rating.GetCodechefRatingUseCase
import com.hitmeows.portfolio_yadav_ashish_02.domain.use_case.get_codeforces_rating.GetCodeforcesInfoUseCase
import com.hitmeows.portfolio_yadav_ashish_02.domain.use_case.get_firebase_image.GetImageFromFirebaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RatingScreenViewmodel @Inject constructor(
    private val getCodeforcesInfoUseCase: GetCodeforcesInfoUseCase,
    private val getCodechefRatingUseCase: GetCodechefRatingUseCase,
    private val getImageFromFirebaseUseCase: GetImageFromFirebaseUseCase
) : ViewModel() {
    private val _cfState = mutableStateOf(CodeforcesState())
    val cfState: State<CodeforcesState> = _cfState
    private val _ccState = mutableStateOf(CodechefState())
    val ccState: State<CodechefState> = _ccState
    private val _fbState = mutableStateOf(FirebaseState())
    val fbState: State<FirebaseState> = _fbState


    init {
        getCodeforcesInfo(Constants.MY_CODEFORCES_HANDLE)
        getCodechefRating(Constants.MY_CODECHEF_HANDLE)
        getProfilePicture()
    }

    private fun getCodeforcesInfo(handle: String) {
        getCodeforcesInfoUseCase(handle).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _cfState.value = CodeforcesState(info = result.data)
                }
                is Resource.Error -> {
                    _cfState.value = CodeforcesState(
                        error = result.message ?: "Unexpected error!"
                    )
                }
                is Resource.Loading -> {
                    _cfState.value = CodeforcesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getCodechefRating(handle: String) {
        getCodechefRatingUseCase(handle).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _ccState.value = CodechefState(rating = result.data)
                }
                is Resource.Error -> {
                    _ccState.value = CodechefState(
                        error = result.message ?: "Unexpected error!"
                    )
                }
                is Resource.Loading -> {
                    _ccState.value = CodechefState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getProfilePicture() {
        getImageFromFirebaseUseCase(Constants.PARAM_PROFILE_PICTURE).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    val reference = result.data
                    if (reference!=null) {
                        reference.addValueEventListener(
                            object : ValueEventListener {
                                override fun onDataChange(snapshot: DataSnapshot) {
                                    _fbState.value = FirebaseState(isLoading = true)
                                    val link = snapshot.getValue<String>()
                                    if (link!=null) {
                                        _fbState.value = FirebaseState(link = link)
                                    }
                                }
                                override fun onCancelled(error: DatabaseError) {
                                    TODO("Not yet implemented")
                                }
                            }
                        )
                    } else {
                        _fbState.value = FirebaseState(error = "null")
                    }
                }
                is Resource.Error -> {
                    _fbState.value = FirebaseState(error = result.message?:"error")
                }
                is Resource.Loading -> {
                    _fbState.value = FirebaseState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}