package com.brandjunhoe.userservice.user.application.dto

import javax.validation.constraints.NotBlank

/**
 * Create by DJH on 2022/03/17.
 */
data class WishProductDTO(

    val regdate: String,

    val productName: String,

    val productPrice: String,

    val productStockState: String,

    val reviewCount: Int,

    val rivewAvgScore: Float

)
