package com.brandjunhoe.userservice.user.domain

import java.util.*

interface WishRepository {
    fun findById(id: UUID): Wish?
}