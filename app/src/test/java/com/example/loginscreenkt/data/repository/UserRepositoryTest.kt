package com.example.loginscreenkt.data.repository

import org.junit.Assert.*

import org.junit.Test

class UserRepositoryTest {

    @Test
    fun list() {
        val userRepository = UserRepository()
        val usersList = userRepository.list()
        val success = usersList.isNotEmpty()
        assert(success)
    }

    @Test
    fun verifyLoggedUser() {
        val userRepository = UserRepository()
        val isUserLogged = userRepository.verifyLoggedUser()
        assert(isUserLogged)
    }
}