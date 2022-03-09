package com.brandjunhoe.userservice.user.application

import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {


    fun get(): List<User> {
        return userRepository.findAll()
    }

}