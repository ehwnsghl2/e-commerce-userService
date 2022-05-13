package com.brandjunhoe.userservice.user.application

import com.brandjunhoe.userservice.common.exception.BadRequestException
import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.UserRepository
import com.brandjunhoe.userservice.user.presentation.dto.ReqSignupDTO
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun signup(request: ReqSignupDTO) {

        if (userRepository.existsByEmail(request.email))
            throw BadRequestException("exist email")

        userRepository.save(request.toEntity(passwordEncoder.encode(request.password)))

    }

}