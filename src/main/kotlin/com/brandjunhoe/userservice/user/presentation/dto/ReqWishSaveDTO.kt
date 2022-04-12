package com.brandjunhoe.userservice.user.presentation.dto

import com.brandjunhoe.userservice.wish.domain.Wish
import java.util.*
import javax.validation.constraints.NotBlank

/**
 * Create by DJH on 2022/03/16.
 */
data class ReqWishSaveDTO(

    @field:NotBlank
    val productCode: String

) {

    fun toEntity(): Wish =
        Wish(productCode = productCode)

}
