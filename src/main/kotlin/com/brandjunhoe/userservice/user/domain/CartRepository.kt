package com.brandjunhoe.userservice.user.domain

import java.util.*

interface CartRepository {
    fun findById(id: UUID): Cart?
}