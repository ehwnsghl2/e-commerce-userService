package com.brandjunhoe.userservice.shipping.application.dto

import com.brandjunhoe.userservice.shipping.domain.Address
import com.brandjunhoe.userservice.shipping.domain.UserShippingAddress
import java.util.*

class UserShippingAddressDTO(
    val id: UUID,
    val receiver: String,
    val phone: String,
    val address: Address,
    val default: Boolean
) {
    constructor(userShippingAddress: UserShippingAddress) : this(
        userShippingAddress.id,
        userShippingAddress.receiver,
        userShippingAddress.phone,
        userShippingAddress.address,
        userShippingAddress.default
    )
}