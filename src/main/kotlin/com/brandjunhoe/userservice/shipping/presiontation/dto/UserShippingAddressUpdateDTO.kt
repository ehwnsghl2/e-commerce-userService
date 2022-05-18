package com.brandjunhoe.userservice.shipping.presiontation.dto

import com.brandjunhoe.userservice.shipping.domain.Address

class UserShippingAddressUpdateDTO(
    val receiver: String? = null,
    val phone: String? = null,
    val address: Address? = null,
    val default: Boolean? = null
)