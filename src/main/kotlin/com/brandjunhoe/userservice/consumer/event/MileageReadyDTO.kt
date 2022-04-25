package com.brandjunhoe.userservice.consumer.event

import com.brandjunhoe.userservice.user.domain.nums.MileageTypeNum
import java.math.BigDecimal
import java.util.*

/**
 * Create by DJH on 2022/04/18.
 */
data class MileageReadyDTO(

    val usrId: UUID,
    val orderCode: String,
    val productCode: String,
    val type: MileageTypeNum,
    val amount: BigDecimal

) {


}
