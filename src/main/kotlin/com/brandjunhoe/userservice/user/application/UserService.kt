package com.brandjunhoe.userservice.user.application

import com.brandjunhoe.userservice.user.application.exception.UserEmailAlreadyException
import com.brandjunhoe.userservice.user.application.exception.UserNotFoundException
import com.brandjunhoe.userservice.user.domain.UserRepository
import com.brandjunhoe.userservice.user.presentation.dto.ReqSignupDTO
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun signup(request: ReqSignupDTO) {

        if (userRepository.existsByEmail(request.email))
            throw UserEmailAlreadyException()

        userRepository.save(request.toEntity(passwordEncoder.encode(request.password)))

    }

    fun findById(id: UUID) :String? {

       return userRepository.findById(id)?.email


    }

    @Transactional
    fun update(id: UUID) {

        val user = userRepository.findById(id)
            ?: throw UserNotFoundException()

        user.changeBirthday("2")

    }

}