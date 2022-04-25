package com.brandjunhoe.userservice.consumer.event

import com.brandjunhoe.userservice.user.domain.UserMileage
import com.brandjunhoe.userservice.user.domain.nums.MileageStateNum
import com.brandjunhoe.userservice.user.domain.nums.MileageTypeNum
import java.math.BigDecimal
import java.util.*

/**
 * Create by DJH on 2022/04/18.
 */
class MileageSaveDTO(

    val id: UUID,
    val usrId: UUID,
    val orderCode: String,
    val productCode: String,
    val type: MileageTypeNum,
    val state: MileageStateNum,
    val amount: BigDecimal

) {

    fun toEntity() =
        UserMileage(usrId, orderCode, productCode, type, state, amount)

}
