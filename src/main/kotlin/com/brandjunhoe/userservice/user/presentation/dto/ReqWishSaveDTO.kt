package com.brandjunhoe.userservice.user.presentation.dto

import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.Wish
import org.springframework.beans.BeanUtils.copyProperties
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

/**
 * Create by DJH on 2022/03/16.
 */
data class ReqWishSaveDTO(

    @field:NotBlank
    val productCode: String

) {

    fun toEntity(usrId: UUID): Wish =
        Wish(usrId = usrId, productCode = productCode)

}
