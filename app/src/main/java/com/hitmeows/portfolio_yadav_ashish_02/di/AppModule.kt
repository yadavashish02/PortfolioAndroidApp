package com.hitmeows.portfolio_yadav_ashish_02.di

import com.github.slashrootv200.retrofithtmlconverter.HtmlConverterFactory
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hitmeows.portfolio_yadav_ashish_02.common.Constants
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.CodechefApi
import com.hitmeows.portfolio_yadav_ashish_02.data.remote.CodeforcesApi
import com.hitmeows.portfolio_yadav_ashish_02.data.repository.CodechefRepositoryImpl
import com.hitmeows.portfolio_yadav_ashish_02.data.repository.CodeforcesRepositoryImpl
import com.hitmeows.portfolio_yadav_ashish_02.data.repository.FirebaseRepositoryImpl
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.CodechefRepository
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.CodeforcesRepository
import com.hitmeows.portfolio_yadav_ashish_02.domain.repository.FirebaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCodeforcesApi(): CodeforcesApi {
        return Retrofit.Builder()
            .baseUrl(Constants.CODEFORCES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CodeforcesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCodeforcesRepository(api: CodeforcesApi): CodeforcesRepository {
        return CodeforcesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCodechefApi(): CodechefApi {
        return Retrofit.Builder()
            .baseUrl(Constants.CODECHEF_BASE_URL)
            .addConverterFactory(HtmlConverterFactory.create(Constants.CODECHEF_BASE_URL))
            .build().create(CodechefApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCodechefRepository (api: CodechefApi): CodechefRepository {
        return CodechefRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideDatabaseReference(): DatabaseReference {
        return Firebase.database.reference
    }

    @Provides
    @Singleton
    fun provideFirebaseRepository(
        databaseReference: DatabaseReference
    ): FirebaseRepository {
        return FirebaseRepositoryImpl(databaseReference)
    }
}