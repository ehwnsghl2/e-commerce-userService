package com.brandjunhoe.userservice.auth.presentation.dto

import com.brandjunhoe.userservice.user.domain.User
import org.springframework.beans.BeanUtils.copyProperties
import org.springframework.security.crypto.password.PasswordEncoder
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

/**
 * Create by DJH on 2022/03/14.
 */
data class ReqSigninDTO(

    @field:NotBlank @field:Email
    val email: String,

    @field:NotBlank
    val password: String

)