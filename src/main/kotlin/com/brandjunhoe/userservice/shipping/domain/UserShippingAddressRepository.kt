package com.brandjunhoe.userservice.shipping.domain

import java.util.*

interface UserShippingAddressRepository {
    fun save(userShippingAddress: UserShippingAddress): UserShippingAddress
    fun findById(id: UUID): UserShippingAddress?
    fun findByUsrId(usrId: UUID): List<UserShippingAddress>
    fun deleteById(id: UUID)

}
