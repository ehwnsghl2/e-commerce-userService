package com.brandjunhoe.userservice.user.presentation.dto

import com.brandjunhoe.userservice.user.domain.Cart
import com.brandjunhoe.userservice.user.domain.User
import com.brandjunhoe.userservice.user.domain.Wish
import org.springframework.beans.BeanUtils.copyProperties
import org.springframework.security.crypto.password.PasswordEncoder
import java.math.BigDecimal
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

/**
 * Create by DJH on 2022/03/18.
 */
data class ReqCartSaveDTO(

    @field:NotBlank
    val productCode: String,

    @field:NotBlank
    val itemCode: String,

    @field:NotBlank
    val quantity: Int

) {

    fun toEntity(usrId: UUID, amount: BigDecimal): Cart =
        Cart(usrId = usrId, productCode = productCode, itemCode = itemCode, quantity = quantity, amount = amount)

}
