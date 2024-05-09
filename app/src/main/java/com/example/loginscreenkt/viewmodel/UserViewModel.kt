package com.example.loginscreenkt.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.loginscreenkt.data.model.User
import com.example.loginscreenkt.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) {

    //LiveData
    val createUserIsSuccessfull = MutableLiveData<Boolean>()
    val signInIsSuccessfull = MutableLiveData<Boolean>()

    fun signIn(user: User){
        CoroutineScope(Dispatchers.IO).launch {
            val isSigned = userRepository.signIn(user)
            signInIsSuccessfull.postValue(isSigned)
        }
    }

    fun createUser(user: User){
        CoroutineScope(Dispatchers.IO).launch {
            val isCreated = userRepository.createUser(user)
            createUserIsSuccessfull.postValue(isCreated)
        }
    }
}