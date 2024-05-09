package com.example.loginscreenkt.data.repository

import android.widget.Toast
import com.example.loginscreenkt.data.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class UserRepository {
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    suspend fun signIn(user: User): Boolean{
        return auth.signInWithEmailAndPassword(
            user.email, user.password
        ).await() != null
    }

    suspend fun createUser(user: User): Boolean{
        return auth.createUserWithEmailAndPassword(
            user.email, user.password
        ).await() != null
    }

    fun list(): List<String>{
        return listOf("pedro", "paulo", "alex")
    }

    fun verifyLoggedUser(): Boolean{
        return true
    }
}