package com.brandjunhoe.userservice.wish.presentation.dto

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Create by DJH on 2022/03/16.
 */
data class ReqWishSaveDTO(

    @field:NotNull
    val usrId: UUID,

    @field:NotBlank
    val productCode: String

)
