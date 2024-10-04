package com.abdroid.medicalapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Article(
    @PrimaryKey val id: Int = 0,
    val title: String = "",
    val details: String = "",
    val date: String = "",
    val image: String = "",
    val minRead: Int = 0,
) : Parcelable {
    constructor() : this(
        id = 0,
        title = "",
        date = "",
        image = "",
        minRead = 0,
    )
}