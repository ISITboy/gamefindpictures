package com.example.testingtask.di

import com.example.testingtask.data.repository.GameRepositoryImpl
import com.example.testingtask.data.repository.TimerRepositoryImpl
import com.example.testingtask.data.repository.SharedPreferencesRepositoryImpl
import com.example.testingtask.data.storage.sharedPref.SharedPreferences
import com.example.testingtask.domain.repository.SharedPreferencesRepository
import com.example.testingtask.domain.repository.TimerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideGameRepository(): GameRepositoryImpl {
        return GameRepositoryImpl()
    }
    @Provides
    fun providesTimerRepository():TimerRepository =TimerRepositoryImpl()


    @Provides
    @Singleton
    fun providesSharedPrefUserStorageRepository(
        sharedPreferences: SharedPreferences
    ): SharedPreferencesRepository = SharedPreferencesRepositoryImpl(sharedPreferences = sharedPreferences)
}