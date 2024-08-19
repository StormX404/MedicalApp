package com.abdroid.medicalapp.presentation.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.abdroid.medicalapp.domain.model.Article
import com.abdroid.medicalapp.domain.model.Doctor
import com.abdroid.medicalapp.domain.repository.AuthRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val database: DatabaseReference // Injecting the DatabaseReference for better testability
) : ViewModel() {


    var doctorsList by mutableStateOf(emptyList<Doctor>())
        private set

    var articlesList by mutableStateOf(emptyList<Article>())
        private set

    var isLoading by mutableStateOf(true)
        private set

    init {
        fetchDoctorsData()
        fetchArticlesData()
    }

    private fun fetchDoctorsData() {
        val doctorRef = database.child("Top Doctor")

        isLoading = true // Set loading state before starting the listener

        doctorRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val newDoctorsList = snapshot.children.mapNotNull { childSnapshot ->
                    childSnapshot.getValue(Doctor::class.java)
                }
                doctorsList = newDoctorsList
                isLoading = false // Update isLoading when data is loaded
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
                isLoading = false // Update isLoading even if there was an error
                Log.e("FirebaseError", "Error fetching top doctors data", error.toException())
            }
        })
    }
    private fun fetchArticlesData() {
        val articleRef = database.child("Trending Articles")


        articleRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val newArticlesList = snapshot.children.mapNotNull { childSnapshot ->
                    childSnapshot.getValue(Article::class.java)
                }
                articlesList = newArticlesList
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }
}
