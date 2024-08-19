package com.abdroid.medicalapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdroid.medicalapp.domain.model.Doctor

@Database(entities = [Doctor::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun doctorDao(): DoctorDao
}