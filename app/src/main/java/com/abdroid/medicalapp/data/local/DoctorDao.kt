package com.abdroid.medicalapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abdroid.medicalapp.domain.model.Doctor
import kotlinx.coroutines.flow.Flow

@Dao
interface DoctorDao {

    @Query("SELECT * FROM Doctor")
    fun getAllDoctors(): Flow<List<Doctor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoctor(statue: Doctor)

    @Delete
    suspend fun deleteDoctor(statue: Doctor)

    @Query("SELECT * FROM Doctor WHERE name =:name")
    suspend fun getDoctor(name: String): Doctor?
}