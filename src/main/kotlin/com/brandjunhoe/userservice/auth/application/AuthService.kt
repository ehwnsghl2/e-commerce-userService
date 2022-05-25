package com.brandjunhoe.userservice.auth.application

import com.brandjunhoe.userservice.auth.application.dto.UserInfoDTO
import com.brandjunhoe.userservice.auth.presentation.dto.ReqSigninDTO
import com.brandjunhoe.userservice.common.exception.BadRequestException
import com.brandjunhoe.userservice.user.application.exception.UserNotFoundException
import com.brandjunhoe.userservice.user.domain.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {


    fun signin(request: ReqSigninDTO): UserInfoDTO {

        val user = userRepository.findByEmail(request.email) ?: throw UserNotFoundException()

        if (!passwordEncoder.matches(request.password, user.password))
            throw BadRequestException("password not match")

        user.login()

        return UserInfoDTO(user.id)

    }

}