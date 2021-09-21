package com.hitmeows.portfolio_yadav_ashish_02.data.repository

import com.google.firebase.database.DatabaseReference
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.FirebaseRepository
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val databaseReference: DatabaseReference
): FirebaseRepository {
    override suspend fun getImageFromFirebase(name: String): DatabaseReference {
        return databaseReference.child(name)
    }
}