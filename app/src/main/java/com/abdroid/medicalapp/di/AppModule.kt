package com.abdroid.medicalapp.di

import android.app.Application
import com.abdroid.medicalapp.data.manager.LocalUserManagerImpl
import com.abdroid.medicalapp.domain.manager.LocalUserManager
import com.abdroid.medicalapp.domain.use_cases.AppEntryUseCases
import com.abdroid.medicalapp.domain.use_cases.ReadAppEntry
import com.abdroid.medicalapp.domain.use_cases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) : AppEntryUseCases = AppEntryUseCases(
        saveAppEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager)
    )

}