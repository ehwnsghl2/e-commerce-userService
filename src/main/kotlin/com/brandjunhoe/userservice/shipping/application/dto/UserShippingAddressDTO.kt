package com.brandjunhoe.userservice.shipping.application.dto

import com.brandjunhoe.userservice.shipping.domain.Address
import java.util.*

class UserShippingAddressDTO(
    val id: UUID,
    val receiver: String,
    val phone: String,
    val address: Address,
    val default: Boolean
)