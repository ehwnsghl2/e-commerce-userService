package com.brandjunhoe.userservice.user.presentation.dto

import com.brandjunhoe.userservice.user.domain.User
import org.springframework.beans.BeanUtils.copyProperties
import org.springframework.security.crypto.password.PasswordEncoder
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

/**
 * Create by DJH on 2022/03/14.
 */
data class ReqSignupDTO(

    @field:NotBlank @field:Email
    val email: String,

    @field:NotBlank
    val password: String

) {
    fun toEntity(password: String): User =
        User(email = email, password = password)

}
