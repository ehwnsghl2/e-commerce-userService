package com.brandjunhoe.userservice.mileage.domain

import java.util.*

interface UserMileageRepository {

    fun findByUsrIdAndOrderCodeAndProductCode(usrId: UUID, orderCode: String, productCode: String): UserMileage?
    fun save(userMileage: UserMileage): UserMileage
    fun findById(id: UUID): UserMileage?

}