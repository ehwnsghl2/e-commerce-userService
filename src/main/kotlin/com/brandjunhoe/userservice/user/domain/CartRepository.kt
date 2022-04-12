package com.brandjunhoe.userservice.user.domain

import com.brandjunhoe.userservice.cart.domain.Cart
import java.util.*

interface CartRepository {
    fun findById(id: UUID): Cart?
}