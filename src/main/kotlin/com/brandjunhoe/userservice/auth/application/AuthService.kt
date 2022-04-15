package com.brandjunhoe.userservice.auth.application

import com.brandjunhoe.userservice.auth.application.dto.UserInfoDTO
import com.brandjunhoe.userservice.auth.presentation.dto.ReqSigninDTO
import com.brandjunhoe.userservice.common.exception.BadRequestException
import com.brandjunhoe.userservice.common.exception.DataNotFoundException
import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {


    fun signin(request: ReqSigninDTO): UserInfoDTO {

        val signinUser = userRepository.findByEmail(request.email) ?: throw DataNotFoundException("not found user")

        if (!passwordEncoder.matches(request.password, signinUser.password))
            throw BadRequestException("password not match")

        return UserInfoDTO(signinUser.id)

    }

}