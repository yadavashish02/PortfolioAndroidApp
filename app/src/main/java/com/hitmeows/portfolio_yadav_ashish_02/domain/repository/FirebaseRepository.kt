package com.hitmeows.portfolio_yadav_ashish_02.domain.repository

import com.google.firebase.database.DatabaseReference

interface FirebaseRepository {
    suspend fun getImageFromFirebase(name: String) : DatabaseReference
}