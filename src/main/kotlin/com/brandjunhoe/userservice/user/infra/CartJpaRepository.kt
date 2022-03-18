package com.brandjunhoe.userservice.user.infra

import com.brandjunhoe.userservice.user.domain.Cart
import com.brandjunhoe.userservice.user.domain.CartRepository
import com.brandjunhoe.userservice.user.domain.Wish
import com.brandjunhoe.userservice.user.domain.WishRepository
import org.springframework.data.jpa.repository.JpaRepository

interface CartJpaRepository : JpaRepository<Cart, Long>, CartRepository {
}