package com.brandjunhoe.userservice.mileage.domain

import com.brandjunhoe.userservice.mileage.domain.enums.MileageTypeNum
import java.util.*

interface UserMileageRepository {

    fun findByUsrIdAndOrderProductCodeAndType(usrId: UUID, orderProductCode: String, type: MileageTypeNum): UserMileage?
    fun save(userMileage: UserMileage): UserMileage
    fun findById(id: UUID): UserMileage?

}