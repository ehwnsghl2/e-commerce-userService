package com.brandjunhoe.userservice.cart.infra

import com.brandjunhoe.userservice.cart.domain.Cart
import com.brandjunhoe.userservice.cart.domain.CartRepository
import org.springframework.data.jpa.repository.JpaRepository

interface CartJpaRepository : JpaRepository<Cart, Long>, CartRepository {
}