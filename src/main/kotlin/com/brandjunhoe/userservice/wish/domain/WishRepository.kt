package com.brandjunhoe.userservice.wish.domain

import java.util.*

interface WishRepository {
    fun findById(id: UUID): Wish?
}