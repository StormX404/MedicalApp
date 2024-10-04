package com.abdroid.medicalapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Doctor(
    @PrimaryKey val id: Int = 0,
    val name: String = "",
    val specialty: String = "",
    val image: String = "",
    val about: String = "",
    val distance: Int = 0,
    val rate: Double = 0.0
) : Parcelable {
    constructor() : this(
        id = 0,
        name = "",
        specialty = "",
        image = "",
        about = "",
        distance = 0,
        rate = 0.0
    )
}
