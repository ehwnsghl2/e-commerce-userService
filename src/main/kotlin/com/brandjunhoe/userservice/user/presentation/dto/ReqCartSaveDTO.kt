package com.brandjunhoe.userservice.user.presentation.dto

import com.brandjunhoe.userservice.cart.domain.Cart
import java.math.BigDecimal
import java.util.*
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

    fun toEntity(amount: BigDecimal): Cart =
        Cart(productCode = productCode, itemCode = itemCode, quantity = quantity, amount = amount)

}
