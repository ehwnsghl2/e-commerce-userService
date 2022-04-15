package com.brandjunhoe.userservice.cart.presentation.dto

import com.brandjunhoe.userservice.cart.domain.Cart
import java.math.BigDecimal
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Create by DJH on 2022/03/18.
 */
data class ReqCartSaveDTO(

    @field:NotNull
    val usrId: UUID,

    @field:NotBlank
    val productCode: String,

    @field:NotBlank
    val itemCode: String,

    @field:NotNull
    val quantity: Int

) {

    fun toEntity(): Cart =
        Cart(usrId, productCode, itemCode, quantity)

}
