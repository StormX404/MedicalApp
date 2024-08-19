package com.abdroid.medicalapp.di

import android.app.Application
import androidx.room.Room
import com.abdroid.medicalapp.data.local.AppDatabase
import com.abdroid.medicalapp.data.local.DoctorDao
import com.abdroid.medicalapp.data.manager.LocalUserManagerImpl
import com.abdroid.medicalapp.data.repository.AuthRepositoryImpl
import com.abdroid.medicalapp.domain.manager.LocalUserManager
import com.abdroid.medicalapp.domain.repository.AuthRepository
import com.abdroid.medicalapp.domain.use_cases.AppEntryUseCases
import com.abdroid.medicalapp.domain.use_cases.ReadAppEntry
import com.abdroid.medicalapp.domain.use_cases.SaveAppEntry
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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
    fun provideNewsDatabase(
        application: Application
    ): AppDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = AppDatabase::class.java,
            name = "app_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        appDatabase: AppDatabase
    ): DoctorDao = appDatabase.doctorDao()

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) : AppEntryUseCases = AppEntryUseCases(
        saveAppEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun providesFirebaseAuth()  = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideDatabaseReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference
    }

    @Provides
    @Singleton
    fun providesRepositoryImpl(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }

}