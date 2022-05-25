package com.brandjunhoe.userservice.consumer.dto

import com.brandjunhoe.userservice.mileage.domain.enums.MileageStateNum
import com.brandjunhoe.userservice.mileage.domain.enums.MileageTypeNum
import java.math.BigDecimal
import java.util.*

/**
 * Create by DJH on 2022/04/18.
 */
class MileageSaveDTO(

    val usrId: UUID,
    val orderProductCode: String,
    val type: MileageTypeNum,
    val state: MileageStateNum,
    val amount: BigDecimal

)
