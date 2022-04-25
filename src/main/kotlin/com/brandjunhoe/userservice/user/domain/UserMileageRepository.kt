package com.brandjunhoe.userservice.user.domain

import java.util.*

interface UserMileageRepository {

    fun existsByUsrIdAndOrderCodeAndProductCode(usrId: UUID, orderCode: String, productCode: String): Boolean
    fun save(userMileage: UserMileage): UserMileage
    fun findById(id: UUID): UserMileage?

}