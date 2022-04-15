package com.brandjunhoe.userservice.cart.domain

import java.util.*

interface CartRepository {
    fun findById(id: UUID): Cart?
}