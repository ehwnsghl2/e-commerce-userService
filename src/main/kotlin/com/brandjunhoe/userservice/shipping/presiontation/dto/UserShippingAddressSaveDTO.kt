package com.brandjunhoe.userservice.shipping.presiontation.dto

import com.brandjunhoe.userservice.shipping.domain.Address
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class UserShippingAddressSaveDTO(
    @NotBlank
    val usrId: UUID,
    @NotBlank
    val receiver: String,
    @NotBlank
    val phone: String,
    @NotNull
    val address: Address,
    @NotNull
    val default: Boolean
)