package com.brandjunhoe.userservice.client.dto

import com.brandjunhoe.userservice.client.enums.ProductGradeLimitEnum
import com.brandjunhoe.userservice.client.enums.ProductTypeEnum

/**
 * Create by DJH on 2022/04/06.
 */
data class ProductDTO(

    val productCode: String,

    val imagePath: String,

    val name: String,

    val type: ProductTypeEnum,

    val supplierPrice: Int,

    val retailPrice: Int,

    val sellingPrice: Int,

    val displayState: Boolean,

    val sellingState: Boolean,

    val discountRate: Int? = null,

    val discountPrice: Int? = null,

    val gradeLimit: ProductGradeLimitEnum,

    val soldOutState: Boolean,

    val gradeSaleState: Boolean

)