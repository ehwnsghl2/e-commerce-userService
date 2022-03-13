package com.brandjunhoe.userservice.auth.application

import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthService(private val userRepository: UserRepository) {


    fun get(): List<User> {
        return userRepository.findAll()
    }

}